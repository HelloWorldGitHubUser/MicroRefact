package com.lakesidemutual.DTO;
 import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import com.lakesidemutual.domain.policy.InsuranceQuoteRequestAggregateRoot;
public class InsuranceQuoteRequestDto {

 private  Long id;

 private  Date date;

 private  List<RequestStatusChangeDto> statusHistory;

 private  CustomerInfoDto customerInfo;

 private  InsuranceOptionsDto insuranceOptions;

 private  InsuranceQuoteDto insuranceQuote;

 private  String policyId;

 private RestTemplate restTemplate = new RestTemplate();

  String url = "http://3";

public InsuranceQuoteRequestDto() {
}public InsuranceQuoteRequestDto(Long id, Date date, List<RequestStatusChangeDto> statusHistory, CustomerInfoDto customerInfo, InsuranceOptionsDto insuranceOptions, InsuranceQuoteDto insuranceQuote, String policyId) {
    this.id = id;
    this.date = date;
    this.statusHistory = statusHistory;
    this.customerInfo = customerInfo;
    this.insuranceOptions = insuranceOptions;
    this.insuranceQuote = insuranceQuote;
    this.policyId = policyId;
}
public List<RequestStatusChangeDto> getStatusHistory(){
    return statusHistory;
}


public Long getId(){
    return id;
}


public InsuranceOptionsDto getInsuranceOptions(){
    return insuranceOptions;
}


public String getPolicyId(){
    return policyId;
}


public CustomerInfoDto getCustomerInfo(){
    return customerInfo;
}


public InsuranceQuoteDto getInsuranceQuote(){
    return insuranceQuote;
}


public Date getDate(){
    return date;
}


public void setId(Long id){
    this.id = id;
 

  UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url.concat("/setId"))

.queryParam("id",id)
;
restTemplate.put(builder.toUriString(),null);
}


public void setDate(Date date){
    this.date = date;
 

  UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url.concat("/setDate"))

.queryParam("date",date)
;
restTemplate.put(builder.toUriString(),null);
}


public void setStatusHistory(List<RequestStatusChangeDto> statusHistory){
    this.statusHistory = statusHistory;
 

  UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url.concat("/setStatusHistory"))

.queryParam("statusHistory",statusHistory)
;
restTemplate.put(builder.toUriString(),null);
}


public void setCustomerInfo(CustomerInfoDto customerInfo){
    this.customerInfo = customerInfo;
 

  UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url.concat("/setCustomerInfo"))

.queryParam("customerInfo",customerInfo)
;
restTemplate.put(builder.toUriString(),null);
}


public void setInsuranceOptions(InsuranceOptionsDto insuranceOptions){
    this.insuranceOptions = insuranceOptions;
 

  UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url.concat("/setInsuranceOptions"))

.queryParam("insuranceOptions",insuranceOptions)
;
restTemplate.put(builder.toUriString(),null);
}


}