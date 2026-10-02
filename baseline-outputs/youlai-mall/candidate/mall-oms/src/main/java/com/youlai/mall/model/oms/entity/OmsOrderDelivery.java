package com.youlai.mall.model.oms.entity;
 import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.youlai.mall.base.BaseEntity;
import lombok.Builder;
import lombok.Data;
import java.util.Date;
@Data
@Builder
public class OmsOrderDelivery extends BaseEntity{

@TableId(type = IdType.AUTO)
 private  Long id;

 private  Long orderId;

 private  String deliveryCompany;

 private  String deliverySn;

 private  String receiverName;

 private  String receiverPhone;

 private  String receiverPostCode;

 private  String receiverProvince;

 private  String receiverCity;

 private  String receiverRegion;

 private  String receiverDetailAddress;

 private  String remark;

 private  Integer deliveryStatus;

 private  Date deliveryTime;

 private  Date receiveTime;

 private  Integer deleted;


}