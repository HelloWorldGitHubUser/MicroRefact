package com.goodskill.vo;
 import com.goodskill.entity.mysql.User;
import lombok.Data;
import java.util.List;
@Data
public class UserInfoVO {

 private  User user;

 private  List<String> permissions;

 private  List<String> roles;


}