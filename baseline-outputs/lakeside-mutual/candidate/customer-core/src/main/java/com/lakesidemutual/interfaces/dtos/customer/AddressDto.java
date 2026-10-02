package com.lakesidemutual.interfaces.dtos.customer;
 import com.lakesidemutual.domain.customer.Address;
import jakarta.validation.constraints.NotEmpty;
public class AddressDto {

@NotEmpty
 private  String streetAddress;

@NotEmpty
 private  String postalCode;

@NotEmpty
 private  String city;

public AddressDto() {
}public AddressDto(String streetAddress, String postalCode, String city) {
    this.streetAddress = streetAddress;
    this.postalCode = postalCode;
    this.city = city;
}
public Address toDomainObject(){
    return new Address(streetAddress, postalCode, city);
}


public void setStreetAddress(String streetAddress){
    this.streetAddress = streetAddress;
}


public void setCity(String city){
    this.city = city;
}


public String getPostalCode(){
    return postalCode;
}


public void setPostalCode(String postalCode){
    this.postalCode = postalCode;
}


public AddressDto fromDomainObject(Address address){
    return new AddressDto(address.getStreetAddress(), address.getPostalCode(), address.getCity());
}


public String getStreetAddress(){
    return streetAddress;
}


public String getCity(){
    return city;
}


}