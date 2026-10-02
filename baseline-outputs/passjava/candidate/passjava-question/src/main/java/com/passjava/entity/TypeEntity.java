package com.passjava.entity;
 import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;
@Data
@TableName("qms_type")
public class TypeEntity implements Serializable{

 private  long serialVersionUID;

@TableId
 private  Long id;

 private  String type;

 private  String comments;

 private  String logoUrl;

 private  Integer delFlag;

 private  Date createTime;

 private  Date updateTime;


}