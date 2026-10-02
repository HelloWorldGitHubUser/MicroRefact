package com.goodskill.bo;
 import lombok.Data;
import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
@Data
public class UserBO implements Serializable{

@Serial
 private  long serialVersionUID;

 private  Integer id;

 private  String account;

 private  String password;

 private  String username;

 private  Integer locked;

 private  String avatar;

 private  Date lastLoginTime;

 private  String mobile;

 private  String emailAddr;

 private  String thirdAccountId;

 private  String thirdAccountName;

 private  String sourceType;


}