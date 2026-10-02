package com.hoangtien2k3.ecommerce.helper;
 import com.hoangtien2k3.ecommerce.dto.order.CartDto;
import com.hoangtien2k3.ecommerce.dto.order.OrderDto;
import com.hoangtien2k3.ecommerce.dto.response.UserResponse;
import com.hoangtien2k3.ecommerce.model.order.Cart;
import com.hoangtien2k3.ecommerce.model.order.Order;
import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;
public interface CartMappingHelper {


public Cart map(CartDto cartDto){
    if (cartDto == null)
        return null;
    Set<Order> orders = cartDto.getOrderDtos() != null ? cartDto.getOrderDtos().stream().map(orderDto -> Order.builder().orderId(orderDto.getOrderId()).orderDate(orderDto.getOrderDate()).orderDesc(orderDto.getOrderDesc()).orderFee(orderDto.getOrderFee()).build()).collect(Collectors.toSet()) : Collections.emptySet();
    return Cart.builder().cartId(cartDto.getCartId()).userId(cartDto.getUserId()).orders(orders).build();
}
;

}