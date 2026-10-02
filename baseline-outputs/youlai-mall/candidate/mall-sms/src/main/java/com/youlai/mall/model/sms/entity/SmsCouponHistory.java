package com.youlai.mall.model.sms.entity;
 import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;
@TableName(value = "sms_coupon_history")
@Data
public class SmsCouponHistory implements Serializable{

@TableId
 private  Long id;

 private  Long couponId;

 private  Long memberId;

 private  String memberNickname;

 private  String couponCode;

 private  Byte getType;

 private  Byte status;

 private  Date useTime;

 private  Long orderId;

 private  String orderSn;

 private  Date createTime;

 private  Date updateTime;

@TableField(exist = false)
 private  long serialVersionUID;


}