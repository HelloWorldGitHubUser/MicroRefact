package com.passjava.entity;
 import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;
@Data
@TableName("chms_access_token")
public class AccessTokenEntity implements Serializable{

 private  long serialVersionUID;

@TableId
 private  Long id;

 private  String accessToken;

 private  Date expireTime;

 private  Long channelId;

 private  Integer delFlag;

 private  Date createTime;

 private  Date updateTime;


}