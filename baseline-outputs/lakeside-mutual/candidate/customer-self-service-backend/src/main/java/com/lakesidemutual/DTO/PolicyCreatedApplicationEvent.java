package com.lakesidemutual.DTO;
 import java.util.Date;
import org.springframework.context.ApplicationEvent;
public class PolicyCreatedApplicationEvent extends ApplicationEvent{

 private  Date date;

 private  Long insuranceQuoteRequestId;

 private  String policyId;

public PolicyCreatedApplicationEvent(Object source, Date date, Long insuranceQuoteRequestId, String policyId) {
    super(source);
    this.date = date;
    this.insuranceQuoteRequestId = insuranceQuoteRequestId;
    this.policyId = policyId;
}
public String getPolicyId(){
    return policyId;
}


public Long getInsuranceQuoteRequestId(){
    return insuranceQuoteRequestId;
}


public Date getDate(){
    return date;
}


}