package io.gulimall.to.order;
 import io.gulimall.entity.order.OrderEntity;
import io.gulimall.entity.order.OrderItemEntity;
import lombok.Data;
import java.math.BigDecimal;
import java.util.List;
@Data
public class OrderCreateTo {

 private  OrderEntity order;

 private  List<OrderItemEntity> orderItems;

 private  BigDecimal payPrice;

 private  BigDecimal fare;


}