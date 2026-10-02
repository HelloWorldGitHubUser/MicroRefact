package com.youlai.mall.model.oms.bo.OrderBO;
 import com.youlai.mall.base.BaseEntity;
import com.youlai.mall.enums.OrderSourceEnum;
import com.youlai.mall.enums.OrderStatusEnum;
import com.youlai.mall.enums.PaymentMethodEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.time.LocalDateTime;
import java.util.List;
@Data
public class OrderItem {

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