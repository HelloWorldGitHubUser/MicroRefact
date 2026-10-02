package com.youlai.mall.service.oms.app.impl;
 import com.youlai.mall.result.ResultCode;
import com.youlai.mall.security.util.SecurityUtils;
import com.youlai.mall.web.exception.BizException;
import com.youlai.mall.constant.OrderConstants;
import com.youlai.mall.converter.CartConverter;
import com.youlai.mall.model.oms.dto.CartItemDto;
import com.youlai.mall.service.oms.app.CartService;
import com.youlai.mall.service.pms.SkuService;
import com.youlai.mall.model.pms.dto.SkuInfoDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.BoundHashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import java.util.Collections;
import java.util.List;
import com.youlai.mall.Interface.SkuService;
@Service
@Slf4j
@RequiredArgsConstructor
public class CartServiceImpl implements CartService{

 private  RedisTemplate redisTemplate;

 private  SkuService skuService;

 private  CartConverter cartConverter;


@Override
public boolean updateCartItem(CartItemDto cartItem){
    Long memberId;
    try {
        memberId = SecurityUtils.getMemberId();
    } catch (Exception e) {
        throw new BizException(ResultCode.TOKEN_INVALID);
    }
    BoundHashOperations cartHashOperations = getCartHashOperations(memberId);
    String hKey = cartItem.getSkuId() + "";
    if (cartHashOperations.get(hKey) != null) {
        CartItemDto cacheCartItem = (CartItemDto) cartHashOperations.get(hKey);
        if (cartItem.getChecked() != null) {
            cacheCartItem.setChecked(cartItem.getChecked());
        }
        if (cartItem.getCount() != null) {
            cacheCartItem.setCount(cartItem.getCount());
        }
        cartHashOperations.put(hKey, cacheCartItem);
    }
    return true;
}


@Override
public boolean removeCartItem(Long skuId){
    Long memberId;
    try {
        memberId = SecurityUtils.getMemberId();
    } catch (Exception e) {
        throw new BizException(ResultCode.TOKEN_INVALID);
    }
    BoundHashOperations cartHashOperations = getCartHashOperations(memberId);
    String hKey = skuId + "";
    cartHashOperations.delete(hKey);
    return true;
}


public BoundHashOperations getCartHashOperations(Long memberId){
    String cartKey = OrderConstants.MEMBER_CART_PREFIX + memberId;
    BoundHashOperations operations = redisTemplate.boundHashOps(cartKey);
    return operations;
}


@Override
public boolean checkAll(boolean checked){
    Long memberId;
    try {
        memberId = SecurityUtils.getMemberId();
    } catch (Exception e) {
        throw new BizException(ResultCode.TOKEN_INVALID);
    }
    BoundHashOperations cartHashOperations = getCartHashOperations(memberId);
    for (Object value : cartHashOperations.values()) {
        CartItemDto cartItem = (CartItemDto) value;
        cartItem.setChecked(checked);
        String hKey = cartItem.getSkuId() + "";
        cartHashOperations.put(hKey, cartItem);
    }
    return true;
}


@Override
public boolean removeCheckedItem(){
    Long memberId = SecurityUtils.getMemberId();
    if (memberId == null) {
        throw new BizException(ResultCode.TOKEN_INVALID);
    }
    BoundHashOperations cartHashOperations = getCartHashOperations(memberId);
    for (Object value : cartHashOperations.values()) {
        CartItemDto cartItem = (CartItemDto) value;
        if (cartItem.getChecked()) {
            cartHashOperations.delete(cartItem.getSkuId() + "");
        }
    }
    return true;
}


@Override
public List<CartItemDto> listCartItems(Long memberId){
    if (memberId != null) {
        BoundHashOperations cartHashOperations = getCartHashOperations(memberId);
        List<CartItemDto> cartItems = cartHashOperations.values();
        return cartItems;
    }
    return Collections.EMPTY_LIST;
}


@Override
public boolean addCartItem(Long skuId){
    Long memberId = SecurityUtils.getMemberId();
    BoundHashOperations<String, String, CartItemDto> cartHashOperations = getCartHashOperations(memberId);
    String hKey = String.valueOf(skuId);
    CartItemDto cartItem = cartHashOperations.get(hKey);
    if (cartItem != null) {
        // 购物车已存在该商品，更新商品数量
        // 点击一次“加入购物车”，数量+1
        cartItem.setCount(cartItem.getCount() + 1);
        cartItem.setChecked(true);
    } else {
        // 购物车中不存在该商品，新增商品到购物车
        SkuInfoDTO skuInfo = skuService.getSkuInfo(skuId);
        if (skuInfo != null) {
            cartItem = cartConverter.sku2CartItem(skuInfo);
            cartItem.setCount(1);
            cartItem.setChecked(true);
        }
    }
    cartHashOperations.put(hKey, cartItem);
    return true;
}


@Override
public boolean deleteCart(){
    String key = OrderConstants.MEMBER_CART_PREFIX + SecurityUtils.getMemberId();
    redisTemplate.delete(key);
    return true;
}


}