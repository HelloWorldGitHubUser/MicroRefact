package com.hoangtien2k3.ecommerce.helper;
 import com.hoangtien2k3.ecommerce.dto.order.CartDto;
import com.hoangtien2k3.ecommerce.dto.order.OrderDto;
import com.hoangtien2k3.ecommerce.model.order.Cart;
import com.hoangtien2k3.ecommerce.model.order.Order;
public interface OrderMappingHelper {


public Order map(OrderDto orderDto){
    if (orderDto == null)
        return null;
    return Order.builder().orderId(orderDto.getOrderId()).orderDate(orderDto.getOrderDate()).orderDesc(orderDto.getOrderDesc()).orderFee(orderDto.getOrderFee()).productId(orderDto.getProductId()).cart(Cart.builder().cartId(orderDto.getCartDto().getCartId()).userId(orderDto.getCartDto().getUserId()).build()).build();
}
;

}