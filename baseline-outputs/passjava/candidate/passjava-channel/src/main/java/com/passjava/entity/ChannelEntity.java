package com.passjava.entity;
 import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;
@Data
@TableName("chms_channel")
public class ChannelEntity implements Serializable{

 private  long serialVersionUID;

@TableId
 private  Long id;

 private  String name;

 private  String appid;

 private  String appsecret;

 private  Integer delFlag;

 private  Date createTime;

 private  Date updateTime;


}