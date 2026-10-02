package io.gulimall.controller.cart;
 import io.gulimall.interceptor.CartInterceptor;
import io.gulimall.service.cart.CartService;
import io.gulimall.vo.cart.CartItemVo;
import io.gulimall.vo.cart.CartVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.util.List;
@Controller
public class CartController {

@Autowired
 private  CartService cartService;


@RequestMapping("/checkCart")
public String checkCart(Integer isChecked,Long skuId){
    cartService.checkCart(skuId, isChecked);
    return "redirect:/cart.html";
}


@RequestMapping("/success.html")
public String success(){
    return "cart/templates/success";
}


@RequestMapping("/deleteItem")
public String deleteItem(Long skuId){
    cartService.deleteItem(skuId);
    return "redirect:/cart.html";
}


@RequestMapping("/addCartItem")
public String addCartItem(Long skuId,Integer num,RedirectAttributes attributes){
    cartService.addCartItem(skuId, num);
    attributes.addAttribute("skuId", skuId);
    return "redirect:/addCartItemSuccess";
}


@RequestMapping("/addCartItemSuccess")
public String addCartItemSuccess(Long skuId,Model model){
    CartItemVo cartItemVo = cartService.getCartItem(skuId);
    model.addAttribute("cartItem", cartItemVo);
    return "cart/templates/success";
}


@RequestMapping("/cart.html")
public String getCartList(Model model){
    CartVo cartVo = cartService.getCart();
    model.addAttribute("cart", cartVo);
    // 传递用户ID，用于前端判断登录状态
    Long userId = CartInterceptor.threadLocal.get().getUserId();
    model.addAttribute("userId", userId);
    return "cart/templates/cartList";
}


@RequestMapping("/countItem")
public String changeItemCount(Long skuId,Integer num){
    cartService.changeItemCount(skuId, num);
    return "redirect:/cart.html";
}


@ResponseBody
@RequestMapping("/getCheckedItems")
public List<CartItemVo> getCheckedItems(){
    return cartService.getCheckedItems();
}


}