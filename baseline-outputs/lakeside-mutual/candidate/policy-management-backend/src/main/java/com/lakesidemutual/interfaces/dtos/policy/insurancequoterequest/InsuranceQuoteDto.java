package com.lakesidemutual.interfaces.dtos.policy.insurancequoterequest;
 import java.util.Date;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import com.lakesidemutual.domain.policy.InsuranceQuoteEntity;
import com.lakesidemutual.interfaces.dtos.policy.policy.MoneyAmountDto;
public class InsuranceQuoteDto {

@Valid
@NotNull
 private  Date expirationDate;

@Valid
@NotNull
 private  MoneyAmountDto insurancePremium;

@Valid
@NotNull
 private  MoneyAmountDto policyLimit;

public InsuranceQuoteDto() {
}private InsuranceQuoteDto(Date expirationDate, MoneyAmountDto insurancePremium, MoneyAmountDto policyLimit) {
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


public void setInsurancePremium(MoneyAmountDto insurancePremium){
    this.insurancePremium = insurancePremium;
}


public InsuranceQuoteDto fromDomainObject(InsuranceQuoteEntity insuranceQuote){
    Date expirationDate = insuranceQuote.getExpirationDate();
    MoneyAmountDto insurancePremiumDto = MoneyAmountDto.fromDomainObject(insuranceQuote.getInsurancePremium());
    MoneyAmountDto policyLimitDto = MoneyAmountDto.fromDomainObject(insuranceQuote.getPolicyLimit());
    return new InsuranceQuoteDto(expirationDate, insurancePremiumDto, policyLimitDto);
}


public void setExpirationDate(Date expirationDate){
    this.expirationDate = expirationDate;
}


}