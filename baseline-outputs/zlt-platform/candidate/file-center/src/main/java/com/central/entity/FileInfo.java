package com.central.entity;
 import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.io.Serializable;
import java.util.Date;
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("file_info")
public class FileInfo extends Model<FileInfo>{

 private  long serialVersionUID;

@TableId
 private  String id;

 private  String name;

 private  Boolean isImg;

 private  String contentType;

 private  long size;

 private  String path;

 private  String url;

 private  String source;

@TableField(fill = FieldFill.INSERT)
 private  Date createTime;

@TableField(fill = FieldFill.INSERT_UPDATE)
 private  Date updateTime;


}