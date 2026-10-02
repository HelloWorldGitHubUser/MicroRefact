package com.youlai.mall.model.oms.entity;
 import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.youlai.mall.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
@EqualsAndHashCode(callSuper = true)
@Data
public class OmsOrderItem extends BaseEntity{

@TableId(type = IdType.AUTO)
 private  Long id;

 private  Long orderId;

 private  String spuName;

 private  Long skuId;

 private  String skuSn;

 private  String skuName;

 private  String picUrl;

 private  Long price;

 private  Integer quantity;

 private  Long totalAmount;

 private  Integer deleted;


}