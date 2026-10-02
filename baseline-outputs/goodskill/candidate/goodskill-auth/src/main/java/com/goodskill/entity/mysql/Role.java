package com.goodskill.entity.mysql;
 import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.goodskill.entity.BaseColEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.io.Serial;
import java.io.Serializable;
@Data
@EqualsAndHashCode(callSuper = false)
public class Role extends BaseColEntityimplements Serializable{

@Serial
 private  long serialVersionUID;

@TableId(value = "role_id", type = IdType.AUTO)
 private  Integer roleId;

 private  String roleName;

 private  Integer status;

 private  String roleCode;

@JsonIgnore
@TableField(value = "delete_flag")
 private  Integer deleteFlag;


}