package io.gulimall.service.cart;
 import io.gulimall.vo.cart.CartItemVo;
import io.gulimall.vo.cart.CartVo;
import java.util.List;
public interface CartService {


public CartItemVo getCartItem(Long skuId)
;

public void checkCart(Long skuId,Integer isChecked)
;

public void deleteItem(Long skuId)
;

public CartItemVo addCartItem(Long skuId,Integer num)
;

public CartVo getCart()
;

public void changeItemCount(Long skuId,Integer num)
;

public List<CartItemVo> getCheckedItems()
;

}