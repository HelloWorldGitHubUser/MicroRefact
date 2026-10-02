package com.lakesidemutual.interfaces.dtos.policy.policy;
 import java.util.Date;
import org.springframework.hateoas.RepresentationModel;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.lakesidemutual.domain.policy.PolicyAggregateRoot;
public class PolicyDto extends RepresentationModel{

 private  String policyId;

 private  Object customer;

 private  Date creationDate;

 private  PolicyPeriodDto policyPeriod;

 private  String policyType;

 private  MoneyAmountDto deductible;

 private  MoneyAmountDto policyLimit;

 private  MoneyAmountDto insurancePremium;

 private  InsuringAgreementDto insuringAgreement;

@JsonProperty("_expandable")
 private  String[] expandable;

public PolicyDto() {
}public PolicyDto(String policyId, Object customer, Date creationDate, PolicyPeriodDto policyPeriod, String policyType, MoneyAmountDto deductible, MoneyAmountDto policyLimit, MoneyAmountDto insurancePremium, InsuringAgreementDto insuringAgreement) {
    this.policyId = policyId;
    this.customer = customer;
    this.creationDate = creationDate;
    this.policyPeriod = policyPeriod;
    this.policyType = policyType;
    this.deductible = deductible;
    this.policyLimit = policyLimit;
    this.insurancePremium = insurancePremium;
    this.insuringAgreement = insuringAgreement;
    this.expandable = new String[] { "customer" };
}
public void setExpandable(String[] expandable){
    this.expandable = expandable;
}


public InsuringAgreementDto getInsuringAgreement(){
    return insuringAgreement;
}


public void setPolicyId(String policyId){
    this.policyId = policyId;
}


public void setInsuringAgreement(InsuringAgreementDto insuringAgreement){
    this.insuringAgreement = insuringAgreement;
}


public MoneyAmountDto getInsurancePremium(){
    return insurancePremium;
}


public MoneyAmountDto getDeductible(){
    return deductible;
}


public MoneyAmountDto getPolicyLimit(){
    return policyLimit;
}


public void setPolicyPeriod(PolicyPeriodDto policyPeriod){
    this.policyPeriod = policyPeriod;
}


public void setPolicyType(String policyType){
    this.policyType = policyType;
}


public void setInsurancePremium(MoneyAmountDto insurancePremium){
    this.insurancePremium = insurancePremium;
}


public PolicyDto fromDomainObject(PolicyAggregateRoot policy){
    return new PolicyDto(policy.getId().getId(), policy.getCustomerId().getId(), policy.getCreationDate(), PolicyPeriodDto.fromDomainObject(policy.getPolicyPeriod()), policy.getPolicyType().getName(), MoneyAmountDto.fromDomainObject(policy.getDeductible()), MoneyAmountDto.fromDomainObject(policy.getPolicyLimit()), MoneyAmountDto.fromDomainObject(policy.getInsurancePremium()), InsuringAgreementDto.fromDomainObject(policy.getInsuringAgreement()));
}


public Object getCustomer(){
    return customer;
}


public String getPolicyId(){
    return policyId;
}


public Date getCreationDate(){
    return creationDate;
}


public void setDeductible(MoneyAmountDto deductible){
    this.deductible = deductible;
}


public void setCreationDate(Date creationDate){
    this.creationDate = creationDate;
}


public void setCustomer(Object customer){
    this.customer = customer;
}


public void setPolicyLimit(MoneyAmountDto policyLimit){
    this.policyLimit = policyLimit;
}


public String[] getExpandable(){
    return expandable;
}


public PolicyPeriodDto getPolicyPeriod(){
    return policyPeriod;
}


public String getPolicyType(){
    return policyType;
}


}