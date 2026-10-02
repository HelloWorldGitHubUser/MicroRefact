package com.lakesidemutual.interfaces.dtos.selfservice.identityaccess;
 import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
public class SignupRequestDto {

@Email
@NotEmpty
 private  String email;

@NotEmpty
 private  String password;

public SignupRequestDto() {
}public SignupRequestDto(String email, String password) {
    this.email = email;
    this.password = password;
}
public void setPassword(String password){
    this.password = password;
}


public String getPassword(){
    return this.password;
}


public void setEmail(String email){
    this.email = email;
}


public String getEmail(){
    return email;
}


}