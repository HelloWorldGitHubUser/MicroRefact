package com.lakesidemutual.interfaces.dtos.selfservice.customer;
 import org.springframework.hateoas.RepresentationModel;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.lakesidemutual.DTO.CustomerProfileEntity;
public class CustomerDto extends RepresentationModel{

 private  String customerId;

@JsonUnwrapped
 private  CustomerProfileDto customerProfile;

public CustomerDto() {
}
public CustomerProfileDto getCustomerProfile(){
    return this.customerProfile;
}


public void setCustomerId(String customerId){
    this.customerId = customerId;
}


public String getCustomerId(){
    return customerId;
}


public void setCustomerProfile(CustomerProfileDto customerProfile){
    this.customerProfile = customerProfile;
}


public CustomerDto fromDomainObject(com.lakesidemutual.domain.customer.CustomerAggregateRoot customer){
    CustomerDto dto = new CustomerDto();
    dto.setCustomerId(customer.getId().getId());
    if (customer.getCustomerProfile() != null) {
        com.lakesidemutual.domain.customer.CustomerProfileEntity p = customer.getCustomerProfile();
        CustomerProfileDto profile = new CustomerProfileDto();
        profile.setFirstname(p.getFirstname());
        profile.setLastname(p.getLastname());
        profile.setBirthday(p.getBirthday());
        profile.setEmail(p.getEmail());
        profile.setPhoneNumber(p.getPhoneNumber());
        if (p.getCurrentAddress() != null) {
            profile.setCurrentAddress(new AddressDto(p.getCurrentAddress().getStreetAddress(), p.getCurrentAddress().getPostalCode(), p.getCurrentAddress().getCity()));
        }
        dto.setCustomerProfile(profile);
    }
    return dto;
}


}