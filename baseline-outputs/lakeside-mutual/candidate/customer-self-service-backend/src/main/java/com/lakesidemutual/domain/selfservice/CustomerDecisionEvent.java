package com.lakesidemutual.domain.selfservice;
 import java.util.Date;
import org.microserviceapipatterns.domaindrivendesign.DomainEvent;
public class CustomerDecisionEvent implements DomainEvent{

 private  Date date;

 private  Long insuranceQuoteRequestId;

 private  boolean quoteAccepted;

public CustomerDecisionEvent() {
}public CustomerDecisionEvent(Date date, Long insuranceQuoteRequestId, boolean quoteAccepted) {
    this.date = date;
    this.insuranceQuoteRequestId = insuranceQuoteRequestId;
    this.quoteAccepted = quoteAccepted;
}
public void setInsuranceQuoteRequestId(Long insuranceQuoteRequestId){
    this.insuranceQuoteRequestId = insuranceQuoteRequestId;
}


public Long getInsuranceQuoteRequestId(){
    return insuranceQuoteRequestId;
}


public boolean isQuoteAccepted(){
    return quoteAccepted;
}


public void setQuoteAccepted(boolean quoteAccepted){
    this.quoteAccepted = quoteAccepted;
}


public void setDate(Date date){
    this.date = date;
}


public Date getDate(){
    return date;
}


}