package com.youlai.mall.model.system.dto;
 import lombok.Data;
import java.util.Set;
@Data
public class UserAuthInfo {

 private  Long userId;

 private  String username;

 private  String password;

 private  Integer status;

 private  Set<String> roles;

 private  Set<String> perms;

 private  Long deptId;

 private  Integer dataScope;

 private  String nickname;

 private  String mobile;

 private  String email;

 private  String avatar;


}