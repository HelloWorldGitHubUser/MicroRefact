package com.lakesidemutual.DTO;
 import com.lakesidemutual.domain.customer.CustomerId;
import com.lakesidemutual.domain.policy.CustomerInfoEntity;
import com.lakesidemutual.interfaces.dtos.policy.customer.AddressDto;
public class CustomerInfoDto {

 private  String customerId;

 private  String firstname;

 private  String lastname;

 private  AddressDto contactAddress;

 private  AddressDto billingAddress;

 private RestTemplate restTemplate = new RestTemplate();

  String url = "http://3";

public CustomerInfoDto() {
}private CustomerInfoDto(String customerId, String firstname, String lastname, AddressDto contactAddress, AddressDto billingAddress) {
    this.customerId = customerId;
    this.firstname = firstname;
    this.lastname = lastname;
    this.contactAddress = contactAddress;
    this.billingAddress = billingAddress;
}
public String getFirstname(){
    return firstname;
}


public AddressDto getBillingAddress(){
    return billingAddress;
}


public String getCustomerId(){
    return customerId;
}


public String getLastname(){
    return lastname;
}


public AddressDto getContactAddress(){
    return contactAddress;
}


public void setCustomerId(String customerId){
    this.customerId = customerId;
 

  UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url.concat("/setCustomerId"))

.queryParam("customerId",customerId)
;
restTemplate.put(builder.toUriString(),null);
}


public void setFirstname(String firstname){
    this.firstname = firstname;
 

  UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url.concat("/setFirstname"))

.queryParam("firstname",firstname)
;
restTemplate.put(builder.toUriString(),null);
}


public void setLastname(String lastname){
    this.lastname = lastname;
 

  UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url.concat("/setLastname"))

.queryParam("lastname",lastname)
;
restTemplate.put(builder.toUriString(),null);
}


public void setContactAddress(AddressDto contactAddress){
    this.contactAddress = contactAddress;
 

  UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url.concat("/setContactAddress"))

.queryParam("contactAddress",contactAddress)
;
restTemplate.put(builder.toUriString(),null);
}


public void setBillingAddress(AddressDto billingAddress){
    this.billingAddress = billingAddress;
 

  UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url.concat("/setBillingAddress"))

.queryParam("billingAddress",billingAddress)
;
restTemplate.put(builder.toUriString(),null);
}


}