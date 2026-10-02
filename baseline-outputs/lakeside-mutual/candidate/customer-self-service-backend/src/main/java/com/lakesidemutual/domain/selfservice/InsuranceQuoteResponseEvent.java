package com.lakesidemutual.domain.selfservice;
 import java.util.Date;
import org.microserviceapipatterns.domaindrivendesign.DomainEvent;
import com.lakesidemutual.interfaces.dtos.selfservice.insurancequoterequest.MoneyAmountDto;
public class InsuranceQuoteResponseEvent implements DomainEvent{

 private  Date date;

 private  Long insuranceQuoteRequestId;

 private  boolean requestAccepted;

 private  Date expirationDate;

 private  MoneyAmountDto insurancePremium;

 private  MoneyAmountDto policyLimit;

public InsuranceQuoteResponseEvent() {
}public InsuranceQuoteResponseEvent(Date date, Long insuranceQuoteRequestId, boolean requestAccepted, Date expirationDate, MoneyAmountDto insurancePremium, MoneyAmountDto policyLimit) {
    this.date = date;
    this.insuranceQuoteRequestId = insuranceQuoteRequestId;
    this.requestAccepted = requestAccepted;
    this.expirationDate = expirationDate;
    this.insurancePremium = insurancePremium;
    this.policyLimit = policyLimit;
}
public void setInsuranceQuoteRequestId(Long insuranceQuoteRequestId){
    this.insuranceQuoteRequestId = insuranceQuoteRequestId;
}


public Long getInsuranceQuoteRequestId(){
    return insuranceQuoteRequestId;
}


public MoneyAmountDto getInsurancePremium(){
    return insurancePremium;
}


public void setPolicyLimit(MoneyAmountDto policyLimit){
    this.policyLimit = policyLimit;
}


public void setDate(Date date){
    this.date = date;
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


public Date getDate(){
    return date;
}


public void setRequestAccepted(boolean requestAccepted){
    this.requestAccepted = requestAccepted;
}


public void setInsurancePremium(MoneyAmountDto insurancePremium){
    this.insurancePremium = insurancePremium;
}


public void setExpirationDate(Date expirationDate){
    this.expirationDate = expirationDate;
}


}