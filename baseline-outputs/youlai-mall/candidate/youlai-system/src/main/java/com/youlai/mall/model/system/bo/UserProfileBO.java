package com.youlai.mall.model.system.bo;
 import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import java.util.Date;
import java.util.Set;
@Data
public class UserProfileBO {

 private  Long id;

 private  String username;

 private  String nickname;

 private  String mobile;

 private  String avatar;

 private  Set<String> roleNames;

 private  String deptName;

 private  String email;

 private  Integer gender;

 private  Date createTime;


}