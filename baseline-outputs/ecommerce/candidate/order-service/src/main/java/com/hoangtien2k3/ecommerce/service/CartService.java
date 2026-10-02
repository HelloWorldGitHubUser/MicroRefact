package com.hoangtien2k3.ecommerce.service;
 import com.hoangtien2k3.ecommerce.dto.order.CartDto;
import org.springframework.data.domain.Page;
import java.util.List;
public interface CartService {


public CartDto findById(Integer cartId)
;

public CartDto save(CartDto cartDto)
;

public void deleteById(Integer cartId)
;

public CartDto update(Integer cartId,CartDto cartDto)
;

public Page<CartDto> findAll(int page,int size,String sortBy,String sortOrder)
;

}