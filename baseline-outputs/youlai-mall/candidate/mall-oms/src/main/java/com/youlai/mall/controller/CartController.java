package com.youlai.mall.controller;
 import com.youlai.mall.result.Result;
import com.youlai.mall.security.util.SecurityUtils;
import com.youlai.mall.model.oms.dto.CartItemDto;
import com.youlai.mall.service.oms.app.CartService;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation;
import java.util.List;
import com.youlai.mall.DTO.Result;
@Tag(name = "App-购物车接口")
@RestController
@RequestMapping("/app-api/v1/carts")
@RequiredArgsConstructor
public class CartController {

 private  CartService cartService;


@Operation(summary = "更新购物车商品")
@PutMapping("/skuId/{skuId}")
public Result<T> updateCartItem(Long skuId,CartItemDto cartItem){
    cartItem.setSkuId(skuId);
    boolean result = cartService.updateCartItem(cartItem);
    return Result.judge(result);
}


@Operation(summary = "删除购物车商品")
@DeleteMapping("/skuId/{skuId}")
public Result<T> removeCartItem(Long skuId){
    boolean result = cartService.removeCartItem(skuId);
    return Result.judge(result);
}


@Operation(summary = "添加购物车商品")
@PostMapping
public Result<T> addCartItem(Long skuId){
    cartService.addCartItem(skuId);
    return Result.success();
}


@Operation(summary = "查询购物车")
@GetMapping
public Result<T> getCart(){
    List<CartItemDto> result = cartService.listCartItems(SecurityUtils.getMemberId());
    return Result.success((T) result);
}


@Operation(summary = "全选/全不选购物车商品")
@PatchMapping("/_check")
public Result<T> check(boolean checked){
    boolean result = cartService.checkAll(checked);
    return Result.judge(result);
}


@Operation(summary = "删除购物车")
@DeleteMapping
public Result<T> deleteCart(){
    boolean result = cartService.deleteCart();
    return Result.judge(result);
}


}