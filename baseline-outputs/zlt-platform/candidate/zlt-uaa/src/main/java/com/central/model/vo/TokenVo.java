package com.central.model.vo;
 import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;
import java.util.Date;
@Getter
@Setter
public class TokenVo implements Serializable{

 private  long serialVersionUID;

 private  String tokenValue;

 private  Date expiration;

 private  String username;

 private  String clientId;

 private  String grantType;

 private  String accountType;


}