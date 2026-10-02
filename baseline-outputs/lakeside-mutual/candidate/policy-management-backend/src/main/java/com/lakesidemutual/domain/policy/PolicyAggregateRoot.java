package com.lakesidemutual.domain.policy;
 import java.util.Date;
import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import org.microserviceapipatterns.domaindrivendesign.RootEntity;
import com.lakesidemutual.domain.customer.CustomerId;
import io.github.adr.embedded.MADR;
import com.lakesidemutual.Interface.CustomerId;
@MADR(value = 2, title = "Separation between domain data model and infrastructure data model", contextAndProblem = "JPA / Spring Data annotations usually belong into a separate data model in the infrastructure layer", alternatives = { "Keep the JPA / Spring Data annotations in the domain data model", "Implement a separate data model with JPA / Spring Data annotations in the infrastructure layer" }, chosenAlternative = "Keep the JPA / Spring Data annotations in the domain data model", justification = "The relatively small size of this application does not warrant the additional complexity (yet).")
@Entity(name = "PolicyAggregateRoot")
@jakarta.persistence.Table(name = "pm_policy")
public class PolicyAggregateRoot implements RootEntity{

@EmbeddedId
 private  PolicyId id;

@Embedded
@AttributeOverrides({ @AttributeOverride(name = "id", column = @Column(name = "customerId")) })
 private  CustomerId customerId;

 public  String FIELD_CREATION_DATE;

 private  Date creationDate;

@Embedded
 private  PolicyPeriod policyPeriod;

@Embedded
 private  PolicyType policyType;

@Embedded
@AttributeOverrides({ @AttributeOverride(name = "amount", column = @Column(name = "deductibleAmount")), @AttributeOverride(name = "currency", column = @Column(name = "deductibleCurrency")) })
 private  MoneyAmount deductible;

@Embedded
@AttributeOverrides({ @AttributeOverride(name = "amount", column = @Column(name = "limitAmount")), @AttributeOverride(name = "currency", column = @Column(name = "limitCurrency")) })
 private  MoneyAmount policyLimit;

@Embedded
@AttributeOverrides({ @AttributeOverride(name = "amount", column = @Column(name = "premiumAmount")), @AttributeOverride(name = "currency", column = @Column(name = "premiumCurrency")) })
 private  MoneyAmount insurancePremium;

@OneToOne(cascade = CascadeType.ALL)
 private  InsuringAgreementEntity insuringAgreement;

public PolicyAggregateRoot() {
}public PolicyAggregateRoot(PolicyId id, CustomerId customerId, Date creationDate, PolicyPeriod policyPeriod, PolicyType policyType, MoneyAmount deductible, MoneyAmount policyLimit, MoneyAmount insurancePremium, InsuringAgreementEntity insuringAgreement) {
    this.id = id;
    this.customerId = customerId;
    this.creationDate = creationDate;
    this.policyPeriod = policyPeriod;
    this.policyType = policyType;
    this.deductible = deductible;
    this.policyLimit = policyLimit;
    this.insurancePremium = insurancePremium;
    this.insuringAgreement = insuringAgreement;
}
public InsuringAgreementEntity getInsuringAgreement(){
    return insuringAgreement;
}


public void setInsuringAgreement(InsuringAgreementEntity insuringAgreement){
    this.insuringAgreement = insuringAgreement;
}


public MoneyAmount getInsurancePremium(){
    return insurancePremium;
}


public MoneyAmount getDeductible(){
    return deductible;
}


public MoneyAmount getPolicyLimit(){
    return policyLimit;
}


public PolicyId getId(){
    return id;
}


public void setPolicyPeriod(PolicyPeriod policyPeriod){
    this.policyPeriod = policyPeriod;
}


public CustomerId getCustomerId(){
    return customerId;
}


public void setPolicyType(PolicyType policyType){
    this.policyType = policyType;
}


public void setInsurancePremium(MoneyAmount insurancePremium){
    this.insurancePremium = insurancePremium;
}


public Date getCreationDate(){
    return creationDate;
}


public void setDeductible(MoneyAmount deductible){
    this.deductible = deductible;
}


public void setPolicyLimit(MoneyAmount policyLimit){
    this.policyLimit = policyLimit;
}


public PolicyPeriod getPolicyPeriod(){
    return policyPeriod;
}


public PolicyType getPolicyType(){
    return policyType;
}


}