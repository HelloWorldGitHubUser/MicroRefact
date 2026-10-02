package com.passjava.entity;
 import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;
@Data
@TableName("ums_growth_change_history")
public class GrowthChangeHistoryEntity implements Serializable{

 private  long serialVersionUID;

@TableId
 private  Long id;

 private  Long memberId;

 private  Integer changeCount;

 private  String note;

 private  Integer sourceType;

 private  Integer delFlag;

 private  Date createTime;

 private  Date updateTime;


}