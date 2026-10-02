package com.lakesidemutual.interfaces.dtos.policy.insurancequoterequest;
 import java.util.Date;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import com.lakesidemutual.interfaces.dtos.policy.policy.MoneyAmountDto;
public class InsuranceQuoteResponseDto {

@Valid
@NotNull
 private  String status;

@Valid
@Future
 private  Date expirationDate;

@Valid
 private  MoneyAmountDto insurancePremium;

@Valid
 private  MoneyAmountDto policyLimit;

public InsuranceQuoteResponseDto() {
}public InsuranceQuoteResponseDto(String status, Date expirationDate, MoneyAmountDto insurancePremium, MoneyAmountDto policyLimit) {
    this.status = status;
    this.expirationDate = expirationDate;
    this.insurancePremium = insurancePremium;
    this.policyLimit = policyLimit;
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