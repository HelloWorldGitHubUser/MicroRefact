package com.youlai.mall.model.oms.entity;
 import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.youlai.mall.base.BaseEntity;
import lombok.Builder;
import lombok.Data;
import java.util.Date;
@Data
@Builder
public class OmsOrderPay extends BaseEntity{

@TableId(type = IdType.AUTO)
 private  Long id;

 private  Long orderId;

 private  String paySn;

 private  Long payAmount;

 private  Date payTime;

 private  Integer payType;

 private  Integer payStatus;

 private  Date confirmTime;

 private  String callbackContent;

 private  Date callbackTime;

 private  String paySubject;

 private  Integer deleted;


}