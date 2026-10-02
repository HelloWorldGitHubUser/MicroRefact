package com.lakesidemutual.interfaces.dtos.customer;
 import java.util.Collection;
import java.util.Date;
import java.util.Set;
import org.springframework.hateoas.RepresentationModel;
import com.lakesidemutual.domain.customer.Address;
import com.lakesidemutual.domain.customer.CustomerAggregateRoot;
import com.lakesidemutual.domain.customer.CustomerProfileEntity;
public class CustomerResponseDto extends RepresentationModel{

 private  String customerId;

 private  String firstname;

 private  String lastname;

 private  Date birthday;

 private  String streetAddress;

 private  String postalCode;

 private  String city;

 private  String email;

 private  String phoneNumber;

 private  Collection<Address> moveHistory;

public CustomerResponseDto(Set<String> includedFields, CustomerAggregateRoot customer) {
    this.customerId = select(includedFields, "customerId", customer.getId().getId());
    final CustomerProfileEntity profile = customer.getCustomerProfile();
    this.firstname = select(includedFields, "firstname", profile.getFirstname());
    this.lastname = select(includedFields, "lastname", profile.getLastname());
    this.birthday = select(includedFields, "birthday", profile.getBirthday());
    this.streetAddress = select(includedFields, "streetAddress", profile.getCurrentAddress().getStreetAddress());
    this.postalCode = select(includedFields, "postalCode", profile.getCurrentAddress().getPostalCode());
    this.city = select(includedFields, "city", profile.getCurrentAddress().getCity());
    this.email = select(includedFields, "email", profile.getEmail());
    this.phoneNumber = select(includedFields, "phoneNumber", profile.getPhoneNumber());
    this.moveHistory = select(includedFields, "moveHistory", profile.getMoveHistory());
}
public T select(Set<String> includedFields,String fieldName,T value){
    if (includedFields.isEmpty() || includedFields.contains(fieldName)) {
        return value;
    } else {
        return null;
    }
}


public String getFirstname(){
    return firstname;
}


public Date getBirthday(){
    return birthday;
}


public Collection<Address> getMoveHistory(){
    return moveHistory;
}


public String getEmail(){
    return email;
}


public String getPhoneNumber(){
    return phoneNumber;
}


public String getCustomerId(){
    return customerId;
}


public String getLastname(){
    return lastname;
}


public String getPostalCode(){
    return postalCode;
}


public String getStreetAddress(){
    return streetAddress;
}


public String getCity(){
    return city;
}


}