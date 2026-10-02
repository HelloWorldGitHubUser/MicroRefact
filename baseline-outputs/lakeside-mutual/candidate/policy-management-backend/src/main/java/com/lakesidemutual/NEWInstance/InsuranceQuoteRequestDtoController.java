package com.lakesidemutual.NEWInstance;
 import org.springframework.web.bind.annotation.*;
@RestController
@CrossOrigin
public class InsuranceQuoteRequestDtoController {

 private InsuranceQuoteRequestDto insurancequoterequestdto;

 private InsuranceQuoteRequestDto insurancequoterequestdto;


@PutMapping
("/setDate")
public void setDate(@RequestParam(name = "date") Date date){
insurancequoterequestdto.setDate(date);
}


@PutMapping
("/setStatusHistory")
public void setStatusHistory(@RequestParam(name = "statusHistory") List<RequestStatusChangeDto> statusHistory){
insurancequoterequestdto.setStatusHistory(statusHistory);
}


@PutMapping
("/setCustomerInfo")
public void setCustomerInfo(@RequestParam(name = "customerInfo") CustomerInfoDto customerInfo){
insurancequoterequestdto.setCustomerInfo(customerInfo);
}


@PutMapping
("/setInsuranceOptions")
public void setInsuranceOptions(@RequestParam(name = "insuranceOptions") InsuranceOptionsDto insuranceOptions){
insurancequoterequestdto.setInsuranceOptions(insuranceOptions);
}


}