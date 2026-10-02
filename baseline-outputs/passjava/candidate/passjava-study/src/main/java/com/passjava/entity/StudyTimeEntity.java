package com.passjava.entity;
 import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;
@Data
@TableName("sms_study_time")
public class StudyTimeEntity implements Serializable{

 private  long serialVersionUID;

@TableId
 private  Long id;

 private  Long quesTypeId;

 private  Long memberId;

 private  Integer totalTime;

 private  Integer delFlag;

 private  Date createTime;

 private  Date updateTime;


}