package com.lakesidemutual.interfaces.selfservice;
 import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import jakarta.validation.Valid;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.lakesidemutual.domain.customer.CustomerId;
import com.lakesidemutual.domain.identityaccess.UserLoginEntity;
import com.lakesidemutual.domain.selfservice.CustomerInfoEntity;
import com.lakesidemutual.domain.selfservice.InsuranceOptionsEntity;
import com.lakesidemutual.domain.selfservice.InsuranceQuoteRequestAggregateRoot;
import com.lakesidemutual.domain.selfservice.RequestStatus;
import com.lakesidemutual.infrastructure.SelfServiceInsuranceQuoteRequestRepository;
import com.lakesidemutual.application.SelfServiceQuoteService;
import com.lakesidemutual.infrastructure.UserLoginRepository;
import com.lakesidemutual.interfaces.dtos.selfservice.insurancequoterequest.CustomerInfoDto;
import com.lakesidemutual.interfaces.dtos.selfservice.insurancequoterequest.InsuranceQuoteRequestDto;
import com.lakesidemutual.interfaces.dtos.selfservice.insurancequoterequest.InsuranceQuoteRequestNotFoundException;
import com.lakesidemutual.interfaces.dtos.selfservice.insurancequoterequest.InsuranceQuoteResponseDto;
@RestController
@RequestMapping("/api/selfservice/insurance-quote-requests")
public class SelfServiceQuoteController {

 private  Logger logger;

@Autowired
 private  SelfServiceInsuranceQuoteRequestRepository insuranceQuoteRequestRepository;

@Autowired
 private  UserLoginRepository userLoginRepository;

@Autowired
 private  SelfServiceQuoteService selfServiceQuoteService;


@Operation(summary = "Get all Insurance Quote Requests.")
@GetMapping
public ResponseEntity<List<InsuranceQuoteRequestDto>> getInsuranceQuoteRequests(){
    List<InsuranceQuoteRequestAggregateRoot> quoteRequests = insuranceQuoteRequestRepository.findAllByOrderByDateDesc();
    List<InsuranceQuoteRequestDto> quoteRequestDtos = quoteRequests.stream().map(InsuranceQuoteRequestDto::fromDomainObject).collect(Collectors.toList());
    return ResponseEntity.ok(quoteRequestDtos);
}


@Operation(summary = "Get a specific Insurance Quote Request.")
@PreAuthorize("isAuthenticated()")
@GetMapping(value = "/{insuranceQuoteRequestId}")
public ResponseEntity<InsuranceQuoteRequestDto> getInsuranceQuoteRequest(Authentication authentication,Long insuranceQuoteRequestId){
    Optional<InsuranceQuoteRequestAggregateRoot> optInsuranceQuoteRequest = insuranceQuoteRequestRepository.findById(insuranceQuoteRequestId);
    if (!optInsuranceQuoteRequest.isPresent()) {
        final String errorMessage = "Failed to find an insurance quote request with id '" + insuranceQuoteRequestId + "'.";
        logger.info(errorMessage);
        throw new InsuranceQuoteRequestNotFoundException(errorMessage);
    }
    InsuranceQuoteRequestAggregateRoot insuranceQuoteRequest = optInsuranceQuoteRequest.get();
    CustomerId loggedInCustomerId = userLoginRepository.findByEmail(authentication.getName()).getCustomerId();
    if (!insuranceQuoteRequest.getCustomerInfo().getCustomerId().equals(loggedInCustomerId)) {
        logger.info("Can't access an Insurance Quote Request of a different customer.");
        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }
    return ResponseEntity.ok(InsuranceQuoteRequestDto.fromDomainObject(insuranceQuoteRequest));
}


@Operation(summary = "Updates the status of an existing Insurance Quote Request")
@PreAuthorize("isAuthenticated()")
@PatchMapping(value = "/{id}")
public ResponseEntity<InsuranceQuoteRequestDto> respondToInsuranceQuote(Authentication authentication,Long id,InsuranceQuoteResponseDto insuranceQuoteResponseDto){
    String loggedInUserEmail = authentication.getName();
    UserLoginEntity loggedInUser = userLoginRepository.findByEmail(loggedInUserEmail);
    CustomerId loggedInCustomerId = loggedInUser.getCustomerId();
    if (loggedInCustomerId == null) {
        logger.info("Customer needs to complete registration first.");
        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }
    Optional<InsuranceQuoteRequestAggregateRoot> optInsuranceQuoteRequest = insuranceQuoteRequestRepository.findById(id);
    if (!optInsuranceQuoteRequest.isPresent()) {
        final String errorMessage = "Failed to respond to insurance quote, because there is no insurance quote request with id '" + id + "'.";
        logger.info(errorMessage);
        throw new InsuranceQuoteRequestNotFoundException(errorMessage);
    }
    final InsuranceQuoteRequestAggregateRoot insuranceQuoteRequest = optInsuranceQuoteRequest.get();
    CustomerId customerId = insuranceQuoteRequest.getCustomerInfo().getCustomerId();
    if (!customerId.equals(loggedInCustomerId)) {
        logger.info("Can't update an Insurance Quote Request of a different customer.");
        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }
    final Date date = new Date();
    if (insuranceQuoteResponseDto.getStatus().equals(RequestStatus.QUOTE_ACCEPTED.toString())) {
        logger.info("Insurance Quote has been accepted.");
        insuranceQuoteRequest.acceptQuote(date);
        selfServiceQuoteService.handleCustomerDecision(date, insuranceQuoteRequest.getId(), true);
    } else if (insuranceQuoteResponseDto.getStatus().equals(RequestStatus.QUOTE_REJECTED.toString())) {
        logger.info("Insurance Quote has been rejected.");
        insuranceQuoteRequest.rejectQuote(date);
        selfServiceQuoteService.handleCustomerDecision(date, insuranceQuoteRequest.getId(), false);
    }
    insuranceQuoteRequestRepository.save(insuranceQuoteRequest);
    InsuranceQuoteRequestDto insuranceQuoteRequestDto = InsuranceQuoteRequestDto.fromDomainObject(insuranceQuoteRequest);
    return ResponseEntity.ok(insuranceQuoteRequestDto);
}


@Operation(summary = "Create a new Insurance Quote Request.")
@PreAuthorize("isAuthenticated()")
@PostMapping
public ResponseEntity<InsuranceQuoteRequestDto> createInsuranceQuoteRequest(Authentication authentication,InsuranceQuoteRequestDto requestDto){
    String loggedInUserEmail = authentication.getName();
    UserLoginEntity loggedInUser = userLoginRepository.findByEmail(loggedInUserEmail);
    CustomerId loggedInCustomerId = loggedInUser.getCustomerId();
    if (loggedInCustomerId == null) {
        logger.info("Customer needs to complete registration first.");
        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }
    CustomerInfoDto customerInfoDto = requestDto.getCustomerInfo();
    CustomerId customerId = new CustomerId(customerInfoDto.getCustomerId());
    if (!customerId.equals(loggedInCustomerId)) {
        logger.info("Can't create an Insurance Quote Request for a different customer.");
        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }
    CustomerInfoEntity customerInfoEntity = customerInfoDto.toDomainObject();
    InsuranceOptionsEntity insuranceOptionsEntity = requestDto.getInsuranceOptions().toDomainObject();
    final Date date = new Date();
    InsuranceQuoteRequestAggregateRoot insuranceQuoteRequest = selfServiceQuoteService.createQuoteRequest(date, requestDto);
    InsuranceQuoteRequestDto responseDto = InsuranceQuoteRequestDto.fromDomainObject(insuranceQuoteRequest);
    return ResponseEntity.ok(responseDto);
}


}