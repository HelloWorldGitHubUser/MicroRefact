package com.goodskill.entity;
 import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
@Data
public class BaseColEntity implements Serializable{

@Serial
 private  long serialVersionUID;

@TableField(value = "create_time", fill = FieldFill.INSERT)
@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
 private  LocalDateTime createTime;

@TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
 private  LocalDateTime updateTime;

@TableField(value = "create_user", fill = FieldFill.INSERT)
 private  String createUser;

@TableField(value = "update_user", fill = FieldFill.INSERT_UPDATE)
 private  String updateUser;


}