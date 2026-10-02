package com.lakesidemutual.interfaces.selfservice;
 import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import jakarta.validation.Valid;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.lakesidemutual.application.CustomerService;
import com.lakesidemutual.domain.customer.Address;
import com.lakesidemutual.domain.customer.CustomerAggregateRoot;
import com.lakesidemutual.domain.customer.CustomerId;
import com.lakesidemutual.domain.customer.CustomerProfileEntity;
import com.lakesidemutual.domain.identityaccess.UserLoginEntity;
import com.lakesidemutual.domain.selfservice.InsuranceQuoteRequestAggregateRoot;
import com.lakesidemutual.infrastructure.SelfServiceInsuranceQuoteRequestRepository;
import com.lakesidemutual.infrastructure.UserLoginRepository;
import com.lakesidemutual.interfaces.dtos.selfservice.customer.AddressDto;
import com.lakesidemutual.interfaces.dtos.selfservice.customer.CustomerDto;
import com.lakesidemutual.interfaces.dtos.selfservice.customer.CustomerNotFoundException;
import com.lakesidemutual.interfaces.dtos.selfservice.customer.CustomerProfileUpdateRequestDto;
import com.lakesidemutual.interfaces.dtos.selfservice.customer.CustomerRegistrationRequestDto;
import com.lakesidemutual.interfaces.dtos.selfservice.insurancequoterequest.InsuranceQuoteRequestDto;
import com.lakesidemutual.Interface.CustomerService;
import com.lakesidemutual.DTO.Address;
import com.lakesidemutual.DTO.CustomerId;
@RestController
@RequestMapping("/api/selfservice/customers")
public class SelfServiceCustomerController {

 private  Logger logger;

@Autowired
 private  UserLoginRepository userLoginRepository;

@Autowired
 private  SelfServiceInsuranceQuoteRequestRepository insuranceQuoteRequestRepository;

@Autowired
 private  CustomerService customerService;


@Operation(summary = "Get a customer's insurance quote requests.")
@PreAuthorize("isAuthenticated()")
@GetMapping(value = "/{customerId}/insurance-quote-requests")
public ResponseEntity<List<InsuranceQuoteRequestDto>> getInsuranceQuoteRequests(CustomerId customerId){
    List<InsuranceQuoteRequestAggregateRoot> insuranceQuoteRequests = insuranceQuoteRequestRepository.findByCustomerInfo_CustomerIdOrderByDateDesc(customerId);
    List<InsuranceQuoteRequestDto> insuranceQuoteRequestDtos = insuranceQuoteRequests.stream().map(InsuranceQuoteRequestDto::fromDomainObject).collect(Collectors.toList());
    return ResponseEntity.ok(insuranceQuoteRequestDtos);
}


@Operation(summary = "Change a customer's address.")
@PreAuthorize("isAuthenticated()")
@PutMapping(value = "/{customerId}/address")
public ResponseEntity<AddressDto> changeAddress(CustomerId customerId,AddressDto requestDto){
    Address address = new Address(requestDto.getStreetAddress(), requestDto.getPostalCode(), requestDto.getCity());
    Optional<CustomerAggregateRoot> updated = customerService.updateAddress(customerId, address);
    if (updated.isEmpty()) {
        return ResponseEntity.notFound().build();
    }
    Address a = updated.get().getCustomerProfile().getCurrentAddress();
    return ResponseEntity.ok(new AddressDto(a.getStreetAddress(), a.getPostalCode(), a.getCity()));
}


public void addHATEOASLinks(CustomerDto customerDto){
    CustomerId customerId = new CustomerId(customerDto.getCustomerId());
    Link selfLink = linkTo(methodOn(SelfServiceCustomerController.class).getCustomer(null, customerId)).withSelfRel();
    Link updateAddressLink = linkTo(methodOn(SelfServiceCustomerController.class).changeAddress(customerId, null)).withRel("address.change");
    customerDto.removeLinks();
    customerDto.add(selfLink);
    customerDto.add(updateAddressLink);
}


@Operation(summary = "Complete the registration of a new customer.")
@PreAuthorize("isAuthenticated()")
@PostMapping
public ResponseEntity<CustomerDto> registerCustomer(Authentication authentication,CustomerRegistrationRequestDto requestDto){
    String loggedInUserEmail = authentication.getName();
    Address address = new Address(requestDto.getStreetAddress(), requestDto.getPostalCode(), requestDto.getCity());
    CustomerProfileEntity profile = new CustomerProfileEntity(requestDto.getFirstname(), requestDto.getLastname(), requestDto.getBirthday(), address, loggedInUserEmail, requestDto.getPhoneNumber());
    CustomerAggregateRoot createdCustomer = customerService.createCustomer(profile);
    CustomerDto customer = CustomerDto.fromDomainObject(createdCustomer);
    UserLoginEntity loggedInUser = userLoginRepository.findByEmail(loggedInUserEmail);
    loggedInUser.setCustomerId(new CustomerId(customer.getCustomerId()));
    userLoginRepository.save(loggedInUser);
    addHATEOASLinks(customer);
    return ResponseEntity.ok(customer);
}


@Operation(summary = "Get customer with a given customer id.")
@PreAuthorize("isAuthenticated()")
@GetMapping(value = "/{customerId}")
public ResponseEntity<CustomerDto> getCustomer(Authentication authentication,CustomerId customerId){
    List<CustomerAggregateRoot> customers = customerService.getCustomers(customerId.getId());
    if (customers.isEmpty()) {
        final String errorMessage = "Failed to find a customer with id '" + customerId.getId() + "'.";
        logger.info(errorMessage);
        throw new CustomerNotFoundException(errorMessage);
    }
    CustomerDto customer = CustomerDto.fromDomainObject(customers.get(0));
    addHATEOASLinks(customer);
    return ResponseEntity.ok(customer);
}


}