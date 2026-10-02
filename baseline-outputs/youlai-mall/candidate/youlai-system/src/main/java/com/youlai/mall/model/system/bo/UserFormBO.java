package com.youlai.mall.model.system.bo;
 import lombok.Data;
import java.util.List;
@Data
public class UserFormBO {

 private  Long id;

 private  String username;

 private  String nickname;

 private  String mobile;

 private  Integer gender;

 private  String avatar;

 private  String email;

 private  Integer status;

 private  Long deptId;

 private  List<Long> roleIds;


}