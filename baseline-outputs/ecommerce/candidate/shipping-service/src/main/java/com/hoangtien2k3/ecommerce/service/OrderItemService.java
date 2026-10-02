package com.hoangtien2k3.ecommerce.service;
 import com.hoangtien2k3.ecommerce.dto.OrderItemDto;
import com.hoangtien2k3.ecommerce.model.shipping.OrderItemId;
import java.util.List;
public interface OrderItemService {


public OrderItemDto findById(OrderItemId orderItemId)
;

public OrderItemDto save(OrderItemDto orderItemDto)
;

public void deleteById(OrderItemId orderItemId)
;

public OrderItemDto update(OrderItemDto orderItemDto)
;

public List<OrderItemDto> findAll()
;

}