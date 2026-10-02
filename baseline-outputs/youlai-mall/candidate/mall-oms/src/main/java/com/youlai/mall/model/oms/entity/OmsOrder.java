package com.youlai.mall.model.oms.entity;
 import com.baomidou.mybatisplus.annotation.FieldStrategy;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.youlai.mall.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.util.Date;
import java.util.List;
@EqualsAndHashCode(callSuper = true)
@Data
public class OmsOrder extends BaseEntity{

@TableId(type = IdType.AUTO)
 private  Long id;

 private  String orderSn;

 private  Long totalAmount;

 private  Integer totalQuantity;

 private  Integer source;

 private  Integer status;

 private  String remark;

 private  Long memberId;

 private  Long couponId;

 private  Long couponAmount;

 private  Long freightAmount;

 private  Long paymentAmount;

 private  Date paymentTime;

 private  Integer paymentMethod;

@TableField(updateStrategy = FieldStrategy.IGNORED)
 private  String outTradeNo;

 private  String transactionId;

 private  String outRefundNo;

 private  String refundId;

 private  Date deliveryTime;

 private  Date receiveTime;

 private  Date commentTime;

 private  Integer deleted;

@TableField(exist = false)
 private  List<OmsOrderItem> orderItems;


}