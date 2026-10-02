package io.gulimall.entity.member;
 import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;
@Data
@TableName("ums_member")
public class MemberEntity implements Serializable{

 private  long serialVersionUID;

@TableId
 private  Long id;

 private  Long levelId;

 private  String username;

 private  String password;

 private  String nickname;

 private  String mobile;

 private  String email;

 private  String header;

 private  Integer gender;

 private  Date birth;

 private  String city;

 private  String job;

 private  String sign;

 private  Integer sourceType;

 private  Integer integration;

 private  Integer growth;

 private  Integer status;

 private  Date createTime;

@TableField(exist = false)
 private  String uid;

@TableField(exist = false)
 private  String accessToken;

@TableField(exist = false)
 private  Long expiresIn;


}