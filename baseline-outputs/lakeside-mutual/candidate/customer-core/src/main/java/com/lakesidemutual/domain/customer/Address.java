package com.lakesidemutual.domain.customer;
 import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.microserviceapipatterns.domaindrivendesign.ValueObject;
import java.util.Objects;
@Entity
@Table(name = "addresses")
public class Address implements ValueObject{

@GeneratedValue
@Id
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
@Override
public int hashCode(){
    return Objects.hash(streetAddress, postalCode, city);
}


@Override
public boolean equals(Object obj){
    if (this == obj) {
        return true;
    }
    if (obj == null) {
        return false;
    }
    if (getClass() != obj.getClass()) {
        return false;
    }
    Address other = (Address) obj;
    return Objects.equals(streetAddress, other.streetAddress) && Objects.equals(postalCode, other.postalCode) && Objects.equals(city, other.city);
}


@Override
public String toString(){
    return String.format("%s, %s %ss", streetAddress, postalCode, city);
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