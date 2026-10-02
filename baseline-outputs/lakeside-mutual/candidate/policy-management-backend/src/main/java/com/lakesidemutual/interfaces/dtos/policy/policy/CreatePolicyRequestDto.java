package com.lakesidemutual.interfaces.dtos.policy.policy;
 import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
public class CreatePolicyRequestDto {

@Valid
 private  String customerId;

@Valid
 private  PolicyPeriodDto policyPeriod;

@Valid
@NotNull
 private  String policyType;

@Valid
 private  MoneyAmountDto deductible;

@Valid
 private  MoneyAmountDto policyLimit;

@Valid
 private  MoneyAmountDto insurancePremium;

@Valid
 private  InsuringAgreementDto insuringAgreement;

public CreatePolicyRequestDto() {
}public CreatePolicyRequestDto(String customerId, PolicyPeriodDto policyPeriod, String policyType, MoneyAmountDto deductible, MoneyAmountDto policyLimit, MoneyAmountDto insurancePremium, InsuringAgreementDto insuringAgreement) {
    this.customerId = customerId;
    this.policyPeriod = policyPeriod;
    this.policyType = policyType;
    this.deductible = deductible;
    this.policyLimit = policyLimit;
    this.insurancePremium = insurancePremium;
    this.insuringAgreement = insuringAgreement;
}
public InsuringAgreementDto getInsuringAgreement(){
    return insuringAgreement;
}


public MoneyAmountDto getInsurancePremium(){
    return insurancePremium;
}


public PolicyPeriodDto getPolicyPeriod(){
    return policyPeriod;
}


public MoneyAmountDto getDeductible(){
    return deductible;
}


public MoneyAmountDto getPolicyLimit(){
    return policyLimit;
}


public String getCustomerId(){
    return customerId;
}


public String getPolicyType(){
    return policyType;
}


}