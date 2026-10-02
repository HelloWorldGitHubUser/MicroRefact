package com.lakesidemutual.DTO;
 import java.util.Date;
import com.lakesidemutual.domain.policy.InsuranceOptionsEntity;
import com.lakesidemutual.domain.policy.InsuranceType;
import com.lakesidemutual.interfaces.dtos.policy.policy.MoneyAmountDto;
public class InsuranceOptionsDto {

 private  Date startDate;

 private  String insuranceType;

 private  MoneyAmountDto deductible;

 private RestTemplate restTemplate = new RestTemplate();

  String url = "http://3";

public InsuranceOptionsDto() {
}private InsuranceOptionsDto(Date startDate, String insuranceType, MoneyAmountDto deductible) {
    this.startDate = startDate;
    this.insuranceType = insuranceType;
    this.deductible = deductible;
}
public Date getStartDate(){
    return startDate;
}


public String getInsuranceType(){
    return insuranceType;
}


public MoneyAmountDto getDeductible(){
    return deductible;
}


public void setStartDate(Date startDate){
    this.startDate = startDate;
 

  UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url.concat("/setStartDate"))

.queryParam("startDate",startDate)
;
restTemplate.put(builder.toUriString(),null);
}


public void setInsuranceType(String insuranceType){
    this.insuranceType = insuranceType;
 

  UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url.concat("/setInsuranceType"))

.queryParam("insuranceType",insuranceType)
;
restTemplate.put(builder.toUriString(),null);
}


public void setDeductible(MoneyAmountDto deductible){
    this.deductible = deductible;
 

  UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url.concat("/setDeductible"))

.queryParam("deductible",deductible)
;
restTemplate.put(builder.toUriString(),null);
}


}