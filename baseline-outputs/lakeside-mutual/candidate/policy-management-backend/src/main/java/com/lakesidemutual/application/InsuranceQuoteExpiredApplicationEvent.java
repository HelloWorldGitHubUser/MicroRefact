package com.lakesidemutual.application;
 import java.util.Date;
import org.springframework.context.ApplicationEvent;
public class InsuranceQuoteExpiredApplicationEvent extends ApplicationEvent{

 private  Date expirationDate;

 private  Long insuranceQuoteRequestId;

public InsuranceQuoteExpiredApplicationEvent(Object source, Date expirationDate, Long insuranceQuoteRequestId) {
    super(source);
    this.expirationDate = expirationDate;
    this.insuranceQuoteRequestId = insuranceQuoteRequestId;
}
public Long getInsuranceQuoteRequestId(){
    return insuranceQuoteRequestId;
}


public Date getExpirationDate(){
    return expirationDate;
}


}