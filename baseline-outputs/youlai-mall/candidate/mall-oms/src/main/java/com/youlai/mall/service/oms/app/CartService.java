package com.youlai.mall.service.oms.app;
 import com.youlai.mall.model.oms.dto.CartItemDto;
import java.util.List;
public interface CartService {


public boolean updateCartItem(CartItemDto cartItem)
;

public boolean removeCartItem(Long skuId)
;

public boolean checkAll(boolean checked)
;

public boolean removeCheckedItem()
;

public List<CartItemDto> listCartItems(Long memberId)
;

public boolean addCartItem(Long skuId)
;

public boolean deleteCart()
;

}