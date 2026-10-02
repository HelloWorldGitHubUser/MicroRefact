package com.lakesidemutual.interfaces.dtos.policy.insurancequoterequest;
 import com.lakesidemutual.domain.customer.CustomerId;
import com.lakesidemutual.domain.policy.CustomerInfoEntity;
import com.lakesidemutual.interfaces.dtos.policy.customer.AddressDto;
public class CustomerInfoDto {

 private  String customerId;

 private  String firstname;

 private  String lastname;

 private  AddressDto contactAddress;

 private  AddressDto billingAddress;

public CustomerInfoDto() {
}private CustomerInfoDto(String customerId, String firstname, String lastname, AddressDto contactAddress, AddressDto billingAddress) {
    this.customerId = customerId;
    this.firstname = firstname;
    this.lastname = lastname;
    this.contactAddress = contactAddress;
    this.billingAddress = billingAddress;
}
public void setLastname(String lastname){
    this.lastname = lastname;
}


public String getFirstname(){
    return firstname;
}


public void setFirstname(String firstname){
    this.firstname = firstname;
}


public CustomerInfoEntity toDomainObject(){
    return new CustomerInfoEntity(new CustomerId(customerId), firstname, lastname, contactAddress.toDomainObject(), billingAddress.toDomainObject());
}


public AddressDto getBillingAddress(){
    return billingAddress;
}


public void setContactAddress(AddressDto contactAddress){
    this.contactAddress = contactAddress;
}


public void setBillingAddress(AddressDto billingAddress){
    this.billingAddress = billingAddress;
}


public void setCustomerId(String customerId){
    this.customerId = customerId;
}


public String getCustomerId(){
    return customerId;
}


public String getLastname(){
    return lastname;
}


public CustomerInfoDto fromDomainObject(CustomerInfoEntity customerInfo){
    String customerId = customerInfo.getCustomerId().getId();
    String firstname = customerInfo.getFirstname();
    String lastname = customerInfo.getLastname();
    AddressDto contactAddressDto = AddressDto.fromDomainObject(customerInfo.getContactAddress());
    AddressDto billingAddressDto = AddressDto.fromDomainObject(customerInfo.getBillingAddress());
    return new CustomerInfoDto(customerId, firstname, lastname, contactAddressDto, billingAddressDto);
}


public AddressDto getContactAddress(){
    return contactAddress;
}


}