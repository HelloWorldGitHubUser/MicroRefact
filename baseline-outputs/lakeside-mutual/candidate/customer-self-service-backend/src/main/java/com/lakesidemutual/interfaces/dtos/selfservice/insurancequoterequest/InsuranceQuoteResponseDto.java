package com.lakesidemutual.interfaces.dtos.selfservice.insurancequoterequest;
 import java.util.Date;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
public class InsuranceQuoteResponseDto {

@NotEmpty
 private  String status;

@Valid
 private  Date expirationDate;

@Valid
 private  MoneyAmountDto insurancePremium;

@Valid
 private  MoneyAmountDto policyLimit;

public InsuranceQuoteResponseDto() {
}
public MoneyAmountDto getInsurancePremium(){
    return insurancePremium;
}


public void setPolicyLimit(MoneyAmountDto policyLimit){
    this.policyLimit = policyLimit;
}


public Date getExpirationDate(){
    return expirationDate;
}


public MoneyAmountDto getPolicyLimit(){
    return policyLimit;
}


public String getStatus(){
    return status;
}


public void setStatus(String status){
    this.status = status;
}


public void setInsurancePremium(MoneyAmountDto insurancePremium){
    this.insurancePremium = insurancePremium;
}


public void setExpirationDate(Date expirationDate){
    this.expirationDate = expirationDate;
}


}