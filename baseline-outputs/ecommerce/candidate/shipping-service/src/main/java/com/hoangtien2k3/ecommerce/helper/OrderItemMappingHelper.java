package com.hoangtien2k3.ecommerce.helper;
 import com.hoangtien2k3.ecommerce.dto.OrderItemDto;
import com.hoangtien2k3.ecommerce.dto.response.OrderResponse;
import com.hoangtien2k3.ecommerce.dto.response.ProductResponse;
import com.hoangtien2k3.ecommerce.model.shipping.OrderItem;
public interface OrderItemMappingHelper {


public OrderItem map(OrderItemDto orderItemDto){
    return OrderItem.builder().productId(orderItemDto.getProductId()).orderId(orderItemDto.getOrderId()).orderedQuantity(orderItemDto.getOrderedQuantity()).build();
}
;

}