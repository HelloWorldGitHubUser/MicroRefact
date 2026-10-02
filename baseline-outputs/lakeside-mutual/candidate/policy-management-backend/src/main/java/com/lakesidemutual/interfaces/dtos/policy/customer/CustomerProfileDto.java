package com.lakesidemutual.interfaces.dtos.policy.customer;
 import java.util.Date;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
public class CustomerProfileDto {

 private  String firstname;

 private  String lastname;

 private  Date birthday;

@JsonUnwrapped
 private  AddressDto currentAddress;

 private  String email;

 private  String phoneNumber;

 private  List<AddressDto> moveHistory;

public CustomerProfileDto() {
}public CustomerProfileDto(String firstname, String lastname, Date birthday, AddressDto currentAddress, String email, String phoneNumber, List<AddressDto> moveHistory) {
    this.firstname = firstname;
    this.lastname = lastname;
    this.birthday = birthday;
    this.currentAddress = currentAddress;
    this.email = email;
    this.phoneNumber = phoneNumber;
    this.moveHistory = moveHistory;
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


public List<AddressDto> getMoveHistory(){
    return moveHistory;
}


public void setBirthday(Date birthday){
    this.birthday = birthday;
}


public void setMoveHistory(List<AddressDto> moveHistory){
    this.moveHistory = moveHistory;
}


public void setEmail(String email){
    this.email = email;
}


public void setPhoneNumber(String phoneNumber){
    this.phoneNumber = phoneNumber;
}


public String getEmail(){
    return email;
}


public AddressDto getCurrentAddress(){
    return currentAddress;
}


public String getPhoneNumber(){
    return phoneNumber;
}


public String getLastname(){
    return lastname;
}


public void setCurrentAddress(AddressDto currentAddress){
    this.currentAddress = currentAddress;
}


}