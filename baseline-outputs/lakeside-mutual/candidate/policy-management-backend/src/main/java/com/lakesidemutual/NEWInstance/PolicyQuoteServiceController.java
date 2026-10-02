package com.lakesidemutual.NEWInstance;
 import org.springframework.web.bind.annotation.*;
@RestController
@CrossOrigin
public class PolicyQuoteServiceController {

 private PolicyQuoteService policyquoteservice;


@PutMapping
("/receiveInsuranceQuoteRequest")
public void receiveInsuranceQuoteRequest(@RequestParam(name = "insuranceQuoteRequestDto") InsuranceQuoteRequestDto insuranceQuoteRequestDto){
policyquoteservice.receiveInsuranceQuoteRequest(insuranceQuoteRequestDto);
}


@PutMapping
("/handleCustomerDecision")
public void handleCustomerDecision(@RequestParam(name = "insuranceQuoteRequestId") Long insuranceQuoteRequestId,@RequestParam(name = "quoteAccepted") boolean quoteAccepted,@RequestParam(name = "decisionDate") Date decisionDate){
policyquoteservice.handleCustomerDecision(insuranceQuoteRequestId,quoteAccepted,decisionDate);
}


}