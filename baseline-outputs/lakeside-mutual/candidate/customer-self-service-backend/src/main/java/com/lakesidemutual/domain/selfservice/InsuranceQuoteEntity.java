package com.lakesidemutual.domain.selfservice;
 import java.util.Date;
import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity(name = "SelfServiceInsuranceQuoteEntity")
@jakarta.persistence.Table(name = "ss_insurance_quote")
public class InsuranceQuoteEntity {

@GeneratedValue
@Id
 private  Long id;

 private  Date expirationDate;

@Embedded
@AttributeOverrides({ @AttributeOverride(name = "amount", column = @Column(name = "insurancePremiumAmount")), @AttributeOverride(name = "currency", column = @Column(name = "insurancePremiumCurrency")) })
 private  MoneyAmount insurancePremium;

@Embedded
@AttributeOverrides({ @AttributeOverride(name = "amount", column = @Column(name = "policyLimitAmount")), @AttributeOverride(name = "currency", column = @Column(name = "policyLimitCurrency")) })
 private  MoneyAmount policyLimit;

public InsuranceQuoteEntity() {
}public InsuranceQuoteEntity(Date expirationDate, MoneyAmount insurancePremium, MoneyAmount policyLimit) {
    this.expirationDate = expirationDate;
    this.insurancePremium = insurancePremium;
    this.policyLimit = policyLimit;
}
public MoneyAmount getInsurancePremium(){
    return insurancePremium;
}


public Date getExpirationDate(){
    return expirationDate;
}


public MoneyAmount getPolicyLimit(){
    return policyLimit;
}


}