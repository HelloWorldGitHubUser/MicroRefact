package io.gulimall.controller.order;
 import java.util.Arrays;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import io.gulimall.entity.order.OrderItemEntity;
import io.gulimall.service.order.OrderItemService;
import io.gulimall.utils.PageUtils;
import io.gulimall.utils.R;
@RestController
@RequestMapping("order/orderitem")
public class OrderItemController {

@Autowired
 private  OrderItemService orderItemService;


@RequestMapping("/save")
public R save(OrderItemEntity orderItem){
    orderItemService.save(orderItem);
    return R.ok();
}


@RequestMapping("/update")
public R update(OrderItemEntity orderItem){
    orderItemService.updateById(orderItem);
    return R.ok();
}


@RequestMapping("/list")
public R list(Map<String,Object> params){
    PageUtils page = orderItemService.queryPage(params);
    return R.ok().put("page", page);
}


@RequestMapping("/delete")
public R delete(Long[] ids){
    orderItemService.removeByIds(Arrays.asList(ids));
    return R.ok();
}


@RequestMapping("/info/{id}")
public R info(Long id){
    OrderItemEntity orderItem = orderItemService.getById(id);
    return R.ok().put("orderItem", orderItem);
}


}