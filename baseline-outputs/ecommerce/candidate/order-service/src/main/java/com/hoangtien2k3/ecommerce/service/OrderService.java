package com.hoangtien2k3.ecommerce.service;
 import com.hoangtien2k3.ecommerce.dto.order.OrderDto;
import org.springframework.data.domain.Page;
import java.util.List;
public interface OrderService {


public OrderDto findById(Integer orderId)
;

public OrderDto save(OrderDto orderDto)
;

public void deleteById(Integer orderId)
;

public OrderDto update(Integer orderId,OrderDto orderDto)
;

public Page<OrderDto> findAll(int page,int size,String sortBy,String sortOrder)
;

public Boolean existsByOrderId(Integer orderId)
;

}