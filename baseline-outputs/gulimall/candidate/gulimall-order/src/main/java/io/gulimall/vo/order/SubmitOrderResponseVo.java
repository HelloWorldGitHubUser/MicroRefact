package io.gulimall.vo.order;
 import io.gulimall.entity.order.OrderEntity;
import lombok.Data;
@Data
public class SubmitOrderResponseVo {

 private  OrderEntity order;

 private  Integer code;


}