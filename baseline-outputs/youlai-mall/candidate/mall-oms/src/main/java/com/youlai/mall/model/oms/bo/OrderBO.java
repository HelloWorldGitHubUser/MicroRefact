package com.youlai.mall.model.oms.bo;
 import com.youlai.mall.base.BaseEntity;
import com.youlai.mall.enums.OrderSourceEnum;
import com.youlai.mall.enums.OrderStatusEnum;
import com.youlai.mall.enums.PaymentMethodEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.time.LocalDateTime;
import java.util.List;
@EqualsAndHashCode(callSuper = true)
@Data
public class OrderBO extends BaseEntity{

 private  Long id;

 private  String orderSn;

 private  Long totalAmount;

 private  Integer totalQuantity;

 private  Integer source;

 private  Integer status;

 private  Long paymentAmount;

 private  Integer paymentMethod;

 private  LocalDateTime createTime;

 private  String remark;

 private  List<OrderItem> orderItems;

 private  Long id;

 private  Long orderId;

 private  Long skuId;

 private  String skuSn;

 private  String skuName;

 private  String picUrl;

 private  Long price;

 private  Integer quantity;

 private  Long totalAmount;


}