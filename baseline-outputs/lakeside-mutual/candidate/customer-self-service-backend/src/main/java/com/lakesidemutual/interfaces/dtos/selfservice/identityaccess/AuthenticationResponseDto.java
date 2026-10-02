package com.lakesidemutual.interfaces.dtos.selfservice.identityaccess;
 public class AuthenticationResponseDto {

 private  String email;

 private  String token;

public AuthenticationResponseDto(String email, String token) {
    this.email = email;
    this.token = token;
}
public void setEmail(String email){
    this.email = email;
}


public void setToken(String token){
    this.token = token;
}


public String getToken(){
    return token;
}


public String getEmail(){
    return email;
}


}