package com.passjava.entity;
 import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;
@Data
@TableName("sms_view_log")
public class ViewLogEntity implements Serializable{

 private  long serialVersionUID;

@TableId
 private  Long id;

 private  Long quesId;

 private  Long quesType;

 private  Long memberId;

 private  Integer delFlag;

 private  Date createTime;

 private  Date updateTime;


}