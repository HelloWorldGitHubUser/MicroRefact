package com.passjava.entity;
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

 private  Integer miniOpenid;

 private  String mpOpenid;

 private  String unionid;

 private  Long levelId;

 private  String userName;

 private  String password;

 private  String nickname;

 private  String phone;

 private  String email;

 private  String avatar;

 private  Integer gender;

 private  Date birth;

 private  String city;

 private  Integer sourceType;

 private  Integer integration;

 private  Date registerTime;

 private  Integer delFlag;

 private  Date createTime;

 private  Date updateTime;

 private  String userId;


}