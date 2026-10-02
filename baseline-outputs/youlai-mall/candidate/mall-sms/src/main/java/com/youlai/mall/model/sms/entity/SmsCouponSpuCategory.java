package com.youlai.mall.model.sms.entity;
 import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;
import java.io.Serializable;
@TableName(value = "sms_coupon_spu_category")
@Data
@Accessors(chain = true)
public class SmsCouponSpuCategory implements Serializable{

@TableId(type = IdType.AUTO)
 private  Long id;

 private  Long couponId;

 private  Long categoryId;

@TableField(exist = false)
 private  long serialVersionUID;


}