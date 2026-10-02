package com.goodskill.server;
 import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.goodskill.entity.BaseColEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
@Data
@EqualsAndHashCode(callSuper = false)
public class User extends BaseColEntityimplements Serializable{

@Serial
 private  long serialVersionUID;

@TableId(value = "id", type = IdType.AUTO)
 private  Integer id;

 private  String account;

 private  String password;

 private  String username;

 private  Integer locked;

 private  String avatar;

 private  LocalDateTime lastLoginTime;

 private  String mobile;

 private  String emailAddr;


}