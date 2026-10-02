package com.lakesidemutual.application;
 import java.util.Date;
import org.springframework.context.ApplicationEvent;
import com.lakesidemutual.interfaces.dtos.policy.policy.MoneyAmountDto;
public class InsuranceQuoteResponseApplicationEvent extends ApplicationEvent{

 private  Long insuranceQuoteRequestId;

 private  boolean requestAccepted;

 private  Date expirationDate;

 private  MoneyAmountDto insurancePremium;

 private  MoneyAmountDto policyLimit;

public InsuranceQuoteResponseApplicationEvent(Object source, Long insuranceQuoteRequestId, boolean requestAccepted, Date expirationDate, MoneyAmountDto insurancePremium, MoneyAmountDto policyLimit) {
    super(source);
    this.insuranceQuoteRequestId = insuranceQuoteRequestId;
    this.requestAccepted = requestAccepted;
    this.expirationDate = expirationDate;
    this.insurancePremium = insurancePremium;
    this.policyLimit = policyLimit;
}
public Long getInsuranceQuoteRequestId(){
    return insuranceQuoteRequestId;
}


public MoneyAmountDto getInsurancePremium(){
    return insurancePremium;
}


public boolean isRequestAccepted(){
    return requestAccepted;
}


public Date getExpirationDate(){
    return expirationDate;
}


public MoneyAmountDto getPolicyLimit(){
    return policyLimit;
}


}