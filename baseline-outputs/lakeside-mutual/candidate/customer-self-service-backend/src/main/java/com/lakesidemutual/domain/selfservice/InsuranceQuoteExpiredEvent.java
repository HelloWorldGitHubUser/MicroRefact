package com.lakesidemutual.domain.selfservice;
 import java.util.Date;
import org.microserviceapipatterns.domaindrivendesign.DomainEvent;
public class InsuranceQuoteExpiredEvent implements DomainEvent{

 private  Date date;

 private  Long insuranceQuoteRequestId;

public InsuranceQuoteExpiredEvent() {
}public InsuranceQuoteExpiredEvent(Date date, Long insuranceQuoteRequestId) {
    this.date = date;
    this.insuranceQuoteRequestId = insuranceQuoteRequestId;
}
public void setInsuranceQuoteRequestId(Long insuranceQuoteRequestId){
    this.insuranceQuoteRequestId = insuranceQuoteRequestId;
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