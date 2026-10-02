package com.passjava.entity;
 import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;
@Data
@TableName("cms_banner")
public class BannerEntity implements Serializable{

 private  long serialVersionUID;

@TableId
 private  Long id;

 private  String imgUrl;

 private  String title;

 private  Integer displayOrder;

 private  Integer enable;

 private  Integer renderType;

 private  String renderUrl;

 private  Integer delFlag;

 private  Date createTime;

 private  Date updateTime;


}