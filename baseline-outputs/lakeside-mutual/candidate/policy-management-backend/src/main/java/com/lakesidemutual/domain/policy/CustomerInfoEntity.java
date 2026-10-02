package com.lakesidemutual.domain.policy;
 import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import com.lakesidemutual.domain.customer.CustomerId;
import com.lakesidemutual.Interface.CustomerId;
@Entity(name = "PolicyCustomerInfoEntity")
@jakarta.persistence.Table(name = "pm_customer_info")
public class CustomerInfoEntity {

@GeneratedValue
@Id
 private  Long id;

@Embedded
@AttributeOverrides({ @AttributeOverride(name = "id", column = @Column(name = "customerId")) })
 private  CustomerId customerId;

 private  String firstname;

 private  String lastname;

@OneToOne(cascade = CascadeType.ALL)
 private  Address contactAddress;

@OneToOne(cascade = CascadeType.ALL)
 private  Address billingAddress;

public CustomerInfoEntity() {
    this.customerId = null;
    this.firstname = null;
    this.lastname = null;
    this.contactAddress = null;
    this.billingAddress = null;
}public CustomerInfoEntity(CustomerId customerId, String firstname, String lastname, Address contactAddress, Address billingAddress) {
    this.customerId = customerId;
    this.firstname = firstname;
    this.lastname = lastname;
    this.contactAddress = contactAddress;
    this.billingAddress = billingAddress;
}
public String getFirstname(){
    return firstname;
}


public Address getBillingAddress(){
    return billingAddress;
}


public void setId(Long id){
    this.id = id;
}


public Long getId(){
    return id;
}


public CustomerId getCustomerId(){
    return customerId;
}


public String getLastname(){
    return lastname;
}


public Address getContactAddress(){
    return contactAddress;
}


}