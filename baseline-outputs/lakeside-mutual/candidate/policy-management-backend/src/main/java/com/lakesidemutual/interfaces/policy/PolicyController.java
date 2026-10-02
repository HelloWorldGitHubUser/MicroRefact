package com.lakesidemutual.interfaces.policy;
 import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.lakesidemutual.domain.customer.CustomerId;
import com.lakesidemutual.domain.policy.InsuringAgreementEntity;
import com.lakesidemutual.domain.policy.MoneyAmount;
import com.lakesidemutual.domain.policy.PolicyAggregateRoot;
import com.lakesidemutual.domain.policy.PolicyId;
import com.lakesidemutual.domain.policy.PolicyPeriod;
import com.lakesidemutual.domain.policy.PolicyType;
import com.lakesidemutual.application.CustomerService;
import com.lakesidemutual.infrastructure.PolicyRepository;
import com.lakesidemutual.interfaces.dtos.policy.UnknownCustomerException;
import com.lakesidemutual.interfaces.dtos.policy.customer.CustomerDto;
import com.lakesidemutual.interfaces.dtos.policy.policy.CreatePolicyRequestDto;
import com.lakesidemutual.interfaces.dtos.policy.policy.PaginatedPolicyResponseDto;
import com.lakesidemutual.interfaces.dtos.policy.policy.PolicyDto;
import com.lakesidemutual.interfaces.dtos.policy.policy.PolicyNotFoundException;
import com.lakesidemutual.Interface.CustomerService;
import com.lakesidemutual.DTO.CustomerId;
@RestController
@RequestMapping("/api/policy/policies")
public class PolicyController {

 private  Logger logger;

@Autowired
 private  PolicyRepository policyRepository;

@Autowired
 private  CustomerService customerService;


public List<PolicyDto> createPolicyDtos(List<PolicyAggregateRoot> policies,String expand){
    List<CustomerDto> customers = null;
    if (expand.equals("customer")) {
        String ids = policies.stream().map(p -> p.getCustomerId().getId()).collect(Collectors.joining(","));
        List<com.lakesidemutual.domain.customer.CustomerAggregateRoot> domainCustomers = customerService.getCustomers(ids);
        customers = domainCustomers.stream().map(c -> CustomerDto.fromDomainObject(c)).collect(Collectors.toList());
    }
    List<PolicyDto> policyDtos = new ArrayList<>();
    for (int i = 0; i < policies.size(); i++) {
        PolicyAggregateRoot policy = policies.get(i);
        PolicyDto policyDto = PolicyDto.fromDomainObject(policy);
        if (customers != null) {
            CustomerDto customer = customers.get(i);
            policyDto.setCustomer(customer);
        }
        policyDtos.add(policyDto);
    }
    return policyDtos;
}


@Operation(summary = "Get all policies, newest first.")
@GetMapping
public ResponseEntity<PaginatedPolicyResponseDto> getPolicies(Integer limit,Integer offset,String expand){
    logger.debug("Fetching a page of policies (offset={},limit={},fields='{}')", offset, limit, expand);
    List<PolicyAggregateRoot> allPolicies = policyRepository.findAll(Sort.by(Sort.Direction.DESC, PolicyAggregateRoot.FIELD_CREATION_DATE));
    List<PolicyAggregateRoot> policies = allPolicies.stream().skip(offset).limit(limit).collect(Collectors.toList());
    List<PolicyDto> policyDtos = createPolicyDtos(policies, expand);
    PaginatedPolicyResponseDto paginatedPolicyResponse = createPaginatedPolicyResponseDto(limit, offset, expand, allPolicies.size(), policyDtos);
    return ResponseEntity.ok(paginatedPolicyResponse);
}


@Operation(summary = "Update an existing policy.")
@PutMapping(value = "/{policyId}")
public ResponseEntity<PolicyDto> updatePolicy(PolicyId policyId,CreatePolicyRequestDto createPolicyDto,HttpServletRequest request){
    logger.info("Updating policy with id '{}'", policyId.getId());
    Optional<PolicyAggregateRoot> optPolicy = policyRepository.findById(policyId);
    if (!optPolicy.isPresent()) {
        final String errorMessage = "Failed to find a policy with id '{}'";
        logger.warn(errorMessage, policyId.getId());
        throw new PolicyNotFoundException(errorMessage);
    }
    CustomerId customerId = new CustomerId(createPolicyDto.getCustomerId());
    List<com.lakesidemutual.domain.customer.CustomerAggregateRoot> domainCustomers = customerService.getCustomers(customerId.getId());
    if (domainCustomers.isEmpty()) {
        final String errorMessage = "Failed to find a customer with id '{}'";
        logger.warn(errorMessage, customerId.getId());
        throw new UnknownCustomerException(errorMessage);
    }
    PolicyType policyType = new PolicyType(createPolicyDto.getPolicyType());
    PolicyPeriod policyPeriod = createPolicyDto.getPolicyPeriod().toDomainObject();
    MoneyAmount deductible = createPolicyDto.getDeductible().toDomainObject();
    MoneyAmount policyLimit = createPolicyDto.getPolicyLimit().toDomainObject();
    MoneyAmount insurancePremium = createPolicyDto.getInsurancePremium().toDomainObject();
    InsuringAgreementEntity insuringAgreement = createPolicyDto.getInsuringAgreement().toDomainObject();
    PolicyAggregateRoot policy = optPolicy.get();
    policy.setPolicyPeriod(policyPeriod);
    policy.setPolicyType(policyType);
    policy.setDeductible(deductible);
    policy.setPolicyLimit(policyLimit);
    policy.setInsurancePremium(insurancePremium);
    policy.setInsuringAgreement(insuringAgreement);
    policyRepository.save(policy);
    PolicyDto response = createPolicyDtos(Arrays.asList(policy), "").get(0);
    return ResponseEntity.ok(response);
}


@Operation(summary = "Delete an existing policy.")
@DeleteMapping(value = "/{policyId}")
public ResponseEntity<Void> deletePolicy(PolicyId policyId,HttpServletRequest request){
    logger.info("Deleting policy with id '{}'", policyId.getId());
    policyRepository.deleteById(policyId);
    return ResponseEntity.noContent().build();
}


@Operation(summary = "Create a new policy.")
@PostMapping
public ResponseEntity<PolicyDto> createPolicy(CreatePolicyRequestDto createPolicyDto,HttpServletRequest request){
    String customerIdString = createPolicyDto.getCustomerId();
    logger.info("Creating a new policy for customer with id '{}'", customerIdString);
    CustomerId customerId = new CustomerId(customerIdString);
    List<com.lakesidemutual.domain.customer.CustomerAggregateRoot> domainCustomers = customerService.getCustomers(customerIdString);
    if (domainCustomers.isEmpty()) {
        final String errorMessage = "Failed to find a customer with id '{}'";
        logger.warn(errorMessage, customerId.getId());
        throw new UnknownCustomerException(errorMessage);
    }
    PolicyId id = PolicyId.random();
    PolicyType policyType = new PolicyType(createPolicyDto.getPolicyType());
    PolicyPeriod policyPeriod = createPolicyDto.getPolicyPeriod().toDomainObject();
    MoneyAmount deductible = createPolicyDto.getDeductible().toDomainObject();
    MoneyAmount policyLimit = createPolicyDto.getPolicyLimit().toDomainObject();
    MoneyAmount insurancePremium = createPolicyDto.getInsurancePremium().toDomainObject();
    InsuringAgreementEntity insuringAgreement = createPolicyDto.getInsuringAgreement().toDomainObject();
    PolicyAggregateRoot policy = new PolicyAggregateRoot(id, customerId, new Date(), policyPeriod, policyType, deductible, policyLimit, insurancePremium, insuringAgreement);
    policyRepository.save(policy);
    PolicyDto policyDto = createPolicyDtos(Arrays.asList(policy), "").get(0);
    return ResponseEntity.ok(policyDto);
}


public PaginatedPolicyResponseDto createPaginatedPolicyResponseDto(Integer limit,Integer offset,String expand,int size,List<PolicyDto> policyDtos){
    PaginatedPolicyResponseDto paginatedPolicyResponseDto = new PaginatedPolicyResponseDto(limit, offset, size, policyDtos);
    paginatedPolicyResponseDto.add(linkTo(methodOn(PolicyController.class).getPolicies(limit, offset, expand)).withSelfRel());
    if (offset > 0) {
        paginatedPolicyResponseDto.add(linkTo(methodOn(PolicyController.class).getPolicies(limit, Math.max(0, offset - limit), expand)).withRel("prev"));
    }
    if (offset < size - limit) {
        paginatedPolicyResponseDto.add(linkTo(methodOn(PolicyController.class).getPolicies(limit, offset + limit, expand)).withRel("next"));
    }
    return paginatedPolicyResponseDto;
}


@Operation(summary = "Get a single policy.")
@GetMapping(value = "/{policyId}")
public ResponseEntity<PolicyDto> getPolicy(PolicyId policyId,String expand){
    logger.debug("Fetching policy with id '{}'", policyId.getId());
    Optional<PolicyAggregateRoot> optPolicy = policyRepository.findById(policyId);
    if (!optPolicy.isPresent()) {
        final String errorMessage = "Failed to find a policy with id '{}'";
        logger.warn(errorMessage, policyId.getId());
        throw new PolicyNotFoundException(errorMessage);
    }
    PolicyAggregateRoot policy = optPolicy.get();
    PolicyDto response = createPolicyDtos(Arrays.asList(policy), expand).get(0);
    return ResponseEntity.ok(response);
}


}