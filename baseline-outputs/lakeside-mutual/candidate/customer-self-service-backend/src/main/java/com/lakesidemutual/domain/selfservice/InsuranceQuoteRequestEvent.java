package com.lakesidemutual.domain.selfservice;
 import java.util.Date;
import com.lakesidemutual.interfaces.dtos.selfservice.insurancequoterequest.InsuranceQuoteRequestDto;
import org.microserviceapipatterns.domaindrivendesign.DomainEvent;
public class InsuranceQuoteRequestEvent implements DomainEvent{

 private  Date date;

 private  InsuranceQuoteRequestDto insuranceQuoteRequestDto;

public InsuranceQuoteRequestEvent() {
}public InsuranceQuoteRequestEvent(Date date, InsuranceQuoteRequestDto insuranceQuoteRequestDto) {
    this.date = date;
    this.insuranceQuoteRequestDto = insuranceQuoteRequestDto;
}
public void setDate(Date date){
    this.date = date;
}


public Date getDate(){
    return date;
}


public InsuranceQuoteRequestDto getInsuranceQuoteRequestDto(){
    return insuranceQuoteRequestDto;
}


public void setInsuranceQuoteRequestDto(InsuranceQuoteRequestDto insuranceQuoteRequestDto){
    this.insuranceQuoteRequestDto = insuranceQuoteRequestDto;
}


}