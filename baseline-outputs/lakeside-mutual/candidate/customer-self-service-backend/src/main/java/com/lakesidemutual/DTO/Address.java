package com.lakesidemutual.DTO;
 import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.microserviceapipatterns.domaindrivendesign.ValueObject;
import java.util.Objects;
public class Address implements ValueObject{

 private  Long id;

 private  String streetAddress;

 private  String postalCode;

 private  String city;

public Address() {
    this.streetAddress = null;
    this.postalCode = null;
    this.city = null;
}public Address(String streetAddress, String postalCode, String city) {
    this.streetAddress = streetAddress;
    this.postalCode = postalCode;
    this.city = city;
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