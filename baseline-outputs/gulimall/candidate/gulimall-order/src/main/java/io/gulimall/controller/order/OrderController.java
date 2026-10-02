package io.gulimall.controller.order;
 import java.util.Arrays;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import io.gulimall.entity.order.OrderEntity;
import io.gulimall.service.order.OrderService;
import io.gulimall.utils.PageUtils;
import io.gulimall.utils.R;
import io.gulimall.security.LoginRequired;
import io.gulimall.DTO.R;
@RestController
@RequestMapping("order/order")
@LoginRequired
public class OrderController {

@Autowired
 private  OrderService orderService;


@RequestMapping("/infoByOrderSn/{OrderSn}")
public R infoByOrderSn(String OrderSn){
    OrderEntity order = orderService.getOrderByOrderSn(OrderSn);
    return R.ok().put("order", order);
}


@RequestMapping("/save")
public R save(OrderEntity order){
    orderService.save(order);
    return R.ok();
}


@RequestMapping("/update")
public R update(OrderEntity order){
    orderService.updateById(order);
    return R.ok();
}


@RequestMapping("/list")
public R list(Map<String,Object> params){
    PageUtils page = orderService.queryPage(params);
    return R.ok().put("page", page);
}


@RequestMapping("/delete")
public R delete(Long[] ids){
    orderService.removeByIds(Arrays.asList(ids));
    return R.ok();
}


@RequestMapping("/info/{id}")
public R info(Long id){
    OrderEntity order = orderService.getById(id);
    return R.ok().put("order", order);
}


}