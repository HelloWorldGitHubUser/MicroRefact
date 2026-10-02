package com.lakesidemutual.interfaces.dtos.policy.customer;
 import org.springframework.hateoas.RepresentationModel;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.lakesidemutual.DTO.CustomerProfileEntity;
public class CustomerDto extends RepresentationModel{

 private  String customerId;

@JsonUnwrapped
 private  CustomerProfileDto customerProfile;

public CustomerDto() {
}public CustomerDto(String customerId, CustomerProfileDto customerProfile) {
    this.customerId = customerId;
    this.customerProfile = customerProfile;
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
        AddressDto currentAddress = null;
        if (p.getCurrentAddress() != null) {
            currentAddress = new AddressDto(p.getCurrentAddress().getStreetAddress(), p.getCurrentAddress().getPostalCode(), p.getCurrentAddress().getCity());
        }
        CustomerProfileDto profile = new CustomerProfileDto(p.getFirstname(), p.getLastname(), p.getBirthday(), currentAddress, p.getEmail(), p.getPhoneNumber(), null);
        dto.setCustomerProfile(profile);
    }
    return dto;
}


}