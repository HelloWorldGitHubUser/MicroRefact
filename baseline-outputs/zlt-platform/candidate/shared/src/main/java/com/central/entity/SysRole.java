package com.central.entity;
 import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.central.enums.DataScope;
import lombok.Data;
import lombok.EqualsAndHashCode;
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("sys_role")
public class SysRole extends SuperEntity<SysRole>{

 private  long serialVersionUID;

 private  String code;

 private  String name;

@TableField(exist = false)
 private  Long userId;

 private  DataScope dataScope;

 private  Long creatorId;


}