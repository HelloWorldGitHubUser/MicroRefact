package com.lakesidemutual.interfaces.dtos.selfservice.customer;
 import java.util.Date;
import java.util.Objects;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.lakesidemutual.interfaces.validation.PhoneNumber;
public class CustomerProfileUpdateRequestDto {

@NotEmpty
 private  String firstname;

@NotEmpty
 private  String lastname;

@JsonFormat(pattern = "yyyy-MM-dd")
 private  Date birthday;

@NotEmpty
 private  String streetAddress;

@NotEmpty
 private  String postalCode;

@NotEmpty
 private  String city;

@Email
@NotEmpty
 private  String email;

@PhoneNumber
 private  String phoneNumber;

public CustomerProfileUpdateRequestDto() {
}public CustomerProfileUpdateRequestDto(String firstname, String lastname, Date birthday, String streetAddress, String postalCode, String city, String email, String phoneNumber) {
    this.firstname = firstname;
    this.lastname = lastname;
    this.birthday = birthday;
    this.streetAddress = streetAddress;
    this.postalCode = postalCode;
    this.city = city;
    this.email = email;
    this.phoneNumber = phoneNumber;
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


public void setEmail(String email){
    this.email = email;
}


public void setStreetAddress(String streetAddress){
    this.streetAddress = streetAddress;
}


public void setPhoneNumber(String phoneNumber){
    this.phoneNumber = phoneNumber;
}


@Override
public int hashCode(){
    return Objects.hash(firstname, lastname, birthday, streetAddress, postalCode, city, email, phoneNumber);
}


@Override
public boolean equals(Object o){
    if (this == o)
        return true;
    if (o == null || getClass() != o.getClass())
        return false;
    CustomerProfileUpdateRequestDto that = (CustomerProfileUpdateRequestDto) o;
    return Objects.equals(firstname, that.firstname) && Objects.equals(lastname, that.lastname) && Objects.equals(birthday, that.birthday) && Objects.equals(streetAddress, that.streetAddress) && Objects.equals(postalCode, that.postalCode) && Objects.equals(city, that.city) && Objects.equals(email, that.email) && Objects.equals(phoneNumber, that.phoneNumber);
}


public String getEmail(){
    return email;
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


public String getStreetAddress(){
    return streetAddress;
}


public String getCity(){
    return city;
}


}