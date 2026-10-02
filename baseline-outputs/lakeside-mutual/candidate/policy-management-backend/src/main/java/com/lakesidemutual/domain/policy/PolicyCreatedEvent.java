package com.lakesidemutual.domain.policy;
 import java.util.Date;
import org.microserviceapipatterns.domaindrivendesign.DomainEvent;
public class PolicyCreatedEvent implements DomainEvent{

 private  Date date;

 private  Long insuranceQuoteRequestId;

 private  String policyId;

public PolicyCreatedEvent() {
}public PolicyCreatedEvent(Date date, Long insuranceQuoteRequestId, String policyId) {
    this.date = date;
    this.insuranceQuoteRequestId = insuranceQuoteRequestId;
    this.policyId = policyId;
}
public String getPolicyId(){
    return policyId;
}


public void setInsuranceQuoteRequestId(Long insuranceQuoteRequestId){
    this.insuranceQuoteRequestId = insuranceQuoteRequestId;
}


public void setPolicyId(String policyId){
    this.policyId = policyId;
}


public Long getInsuranceQuoteRequestId(){
    return insuranceQuoteRequestId;
}


public void setDate(Date date){
    this.date = date;
}


public Date getDate(){
    return date;
}


}