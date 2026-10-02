package com.lakesidemutual.interfaces.dtos.selfservice.customer;
 import java.util.Date;
import java.util.Objects;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.lakesidemutual.interfaces.validation.PhoneNumber;
public class CustomerRegistrationRequestDto {

@NotEmpty
 private  String firstname;

@NotEmpty
 private  String lastname;

@NotNull
@Past
@JsonFormat(pattern = "yyyy-MM-dd")
 private  Date birthday;

@NotEmpty
 private  String city;

@NotEmpty
 private  String streetAddress;

@NotEmpty
 private  String postalCode;

@PhoneNumber
 private  String phoneNumber;

public CustomerRegistrationRequestDto() {
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


public Date getBirthday(){
    return birthday;
}


public void setCity(String city){
    this.city = city;
}


public String getPostalCode(){
    return postalCode;
}


public void setBirthday(Date birthday){
    this.birthday = birthday;
}


public void setStreetAddress(String streetAddress){
    this.streetAddress = streetAddress;
}


public void setPhoneNumber(String phoneNumber){
    this.phoneNumber = phoneNumber;
}


@Override
public int hashCode(){
    return Objects.hash(firstname, lastname, birthday, city, streetAddress, postalCode, phoneNumber);
}


@Override
public boolean equals(Object o){
    if (this == o)
        return true;
    if (o == null || getClass() != o.getClass())
        return false;
    CustomerRegistrationRequestDto that = (CustomerRegistrationRequestDto) o;
    return Objects.equals(firstname, that.firstname) && Objects.equals(lastname, that.lastname) && Objects.equals(birthday, that.birthday) && Objects.equals(city, that.city) && Objects.equals(streetAddress, that.streetAddress) && Objects.equals(postalCode, that.postalCode) && Objects.equals(phoneNumber, that.phoneNumber);
}


public String getPhoneNumber(){
    return phoneNumber;
}


public String getLastname(){
    return lastname;
}


public void setPostalCode(String postalCode){
    this.postalCode = postalCode;
}


public String getCity(){
    return city;
}


public String getStreetAddress(){
    return streetAddress;
}


}