package com.passjava.entity;
 import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;
import javax.validation.constraints.Positive;
@Data
@TableName("qms_question")
public class QuestionEntity implements Serializable{

 private  long serialVersionUID;

@TableId
 private  Long id;

 private  String title;

 private  String answer;

@Positive
 private  Integer level;

@Positive
 private  Integer displayOrder;

 private  String subTitle;

 private  Long type;

@TableField(exist = false)
 private  String typeComments;

 private  Integer enable;

 private  Integer delFlag;

 private  Date createTime;

 private  Date updateTime;


}