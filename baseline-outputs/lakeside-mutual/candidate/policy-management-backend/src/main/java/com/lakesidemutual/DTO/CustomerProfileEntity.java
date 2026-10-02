package com.lakesidemutual.DTO;
 import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Objects;
public class CustomerProfileEntity implements Serializable{

 private  long serialVersionUID;

 private  Long id;

 private  String firstname;

 private  String lastname;

 private  Date birthday;

 private  Address currentAddress;

 private  String email;

 private  String phoneNumber;

 private  Collection<Address> moveHistory;

public CustomerProfileEntity() {
}public CustomerProfileEntity(String firstname, String lastname, Date birthday, Address currentAddress, String email, String phoneNumber) {
    this.firstname = firstname;
    this.lastname = lastname;
    this.birthday = birthday;
    this.currentAddress = currentAddress;
    this.email = email;
    this.phoneNumber = phoneNumber;
    this.moveHistory = new ArrayList<>();
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


public Address getCurrentAddress(){
    return currentAddress;
}


public String getPhoneNumber(){
    return phoneNumber;
}


public String getLastname(){
    return lastname;
}


}