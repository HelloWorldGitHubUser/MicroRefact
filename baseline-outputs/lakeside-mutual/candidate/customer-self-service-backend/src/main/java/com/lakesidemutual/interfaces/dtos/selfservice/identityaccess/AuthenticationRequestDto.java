package com.lakesidemutual.interfaces.dtos.selfservice.identityaccess;
 public class AuthenticationRequestDto {

 private  String email;

 private  String password;

public AuthenticationRequestDto() {
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
    return this.email;
}


}