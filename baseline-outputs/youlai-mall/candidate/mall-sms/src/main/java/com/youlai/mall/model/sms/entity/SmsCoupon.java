package com.youlai.mall.model.sms.entity;
 import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.youlai.mall.base.BaseEntity;
import lombok.Data;
import java.math.BigDecimal;
import java.util.Date;
@TableName(value = "sms_coupon")
@Data
public class SmsCoupon extends BaseEntity{

@TableId(type = IdType.AUTO)
 private  Long id;

 private  Integer type;

 private  String name;

 private  String code;

 private  Integer platform;

 private  Integer faceValueType;

 private  Long faceValue;

 private  BigDecimal discount;

 private  Long minPoint;

 private  Integer perLimit;

 private  Integer validityPeriodType;

 private  Integer validityDays;

 private  Date validityBeginTime;

 private  Date validityEndTime;

 private  Integer applicationScope;

 private  Integer circulation;

 private  Integer receivedCount;

 private  Integer usedCount;

 private  String remark;

@TableLogic(value = "0", delval = "1")
 private  Integer deleted;


}