package com.lakesidemutual.domain.selfservice;
 import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import org.microserviceapipatterns.domaindrivendesign.RootEntity;
@Entity(name = "SelfServiceInsuranceQuoteRequest")
@jakarta.persistence.Table(name = "ss_insurance_quote_request")
public class InsuranceQuoteRequestAggregateRoot implements RootEntity{

@Id
@GeneratedValue
 private  Long id;

 private  Date date;

@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
 private  List<RequestStatusChange> statusHistory;

@OneToOne(cascade = CascadeType.ALL)
 private  CustomerInfoEntity customerInfo;

@OneToOne(cascade = CascadeType.ALL)
 private  InsuranceOptionsEntity insuranceOptions;

@OneToOne(cascade = CascadeType.ALL)
 private  InsuranceQuoteEntity insuranceQuote;

 private  String policyId;

public InsuranceQuoteRequestAggregateRoot() {
}public InsuranceQuoteRequestAggregateRoot(Date date, RequestStatus initialStatus, CustomerInfoEntity customerInfo, InsuranceOptionsEntity insuranceOptions, InsuranceQuoteEntity insuranceQuote, String policyId) {
    this.date = date;
    List<RequestStatusChange> statusHistory = new ArrayList<>();
    statusHistory.add(new RequestStatusChange(date, initialStatus));
    this.statusHistory = statusHistory;
    this.customerInfo = customerInfo;
    this.insuranceOptions = insuranceOptions;
    this.insuranceQuote = insuranceQuote;
    this.policyId = policyId;
}
public void acceptQuote(Date date){
    changeStatusTo(RequestStatus.QUOTE_ACCEPTED, date);
}


public List<RequestStatusChange> getStatusHistory(){
    return statusHistory;
}


public void acceptRequest(InsuranceQuoteEntity insuranceQuote,Date date){
    this.insuranceQuote = insuranceQuote;
    changeStatusTo(RequestStatus.QUOTE_RECEIVED, date);
}


public void changeStatusTo(RequestStatus newStatus,Date date){
    if (!getStatus().canTransitionTo(newStatus)) {
        throw new RuntimeException(String.format("Cannot change insurance quote request status from %s to %s", getStatus(), newStatus));
    }
    statusHistory.add(new RequestStatusChange(date, newStatus));
}


public Long getId(){
    return id;
}


public RequestStatus getStatus(){
    return statusHistory.get(statusHistory.size() - 1).getStatus();
}


public InsuranceOptionsEntity getInsuranceOptions(){
    return insuranceOptions;
}


public void markQuoteAsExpired(Date date){
    changeStatusTo(RequestStatus.QUOTE_EXPIRED, date);
}


public String getPolicyId(){
    return policyId;
}


public void rejectRequest(Date date){
    changeStatusTo(RequestStatus.REQUEST_REJECTED, date);
}


public CustomerInfoEntity getCustomerInfo(){
    return customerInfo;
}


public void rejectQuote(Date date){
    changeStatusTo(RequestStatus.QUOTE_REJECTED, date);
}


public InsuranceQuoteEntity getInsuranceQuote(){
    return insuranceQuote;
}


public Date getDate(){
    return date;
}


public void finalizeQuote(String policyId,Date date){
    changeStatusTo(RequestStatus.POLICY_CREATED, date);
}


}