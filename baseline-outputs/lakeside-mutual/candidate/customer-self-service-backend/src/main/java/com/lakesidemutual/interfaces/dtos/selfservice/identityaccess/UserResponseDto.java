package com.lakesidemutual.interfaces.dtos.selfservice.identityaccess;
 public class UserResponseDto {

 private  String email;

 private  String customerId;

public UserResponseDto(String email, String customerId) {
    this.email = email;
    this.customerId = customerId;
}
public String getEmail(){
    return email;
}


public String getCustomerId(){
    return customerId;
}


}