package com.youlai.mall.model.sms.entity;
 import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.youlai.mall.base.BaseEntity;
import lombok.Data;
import java.util.Date;
@Data
public class SmsAdvert extends BaseEntity{

@TableId(type = IdType.AUTO)
 private  Integer id;

 private  String title;

 private  String imageUrl;

@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
 private  Date startTime;

@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
 private  Date endTime;

 private  Integer status;

 private  Integer sort;

 private  String redirectUrl;

 private  String remark;


}