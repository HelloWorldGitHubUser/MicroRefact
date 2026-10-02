package com.youlai.mall.model.system.bo;
 import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import java.util.Date;
@Data
public class UserBO {

 private  Long id;

 private  String username;

 private  String nickname;

 private  String mobile;

 private  Integer gender;

 private  String avatar;

 private  String email;

 private  Integer status;

 private  String deptName;

 private  String roleNames;

@JsonFormat(pattern = "yyyy-MM-dd")
 private  Date createTime;


}