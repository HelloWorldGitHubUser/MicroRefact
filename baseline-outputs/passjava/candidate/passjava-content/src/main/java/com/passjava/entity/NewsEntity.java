package com.passjava.entity;
 import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;
@Data
@TableName("cms_news")
public class NewsEntity implements Serializable{

 private  long serialVersionUID;

@TableId
 private  Long id;

 private  String imageUrl;

 private  String title;

 private  Integer displayOrder;

 private  String renderUrl;

 private  Integer enable;

 private  Integer delFlag;

 private  Date createTime;

 private  Date updateTime;


}