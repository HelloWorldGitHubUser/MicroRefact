package io.gulimall.controller.order;
 import java.util.Arrays;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import io.gulimall.entity.order.OrderSettingEntity;
import io.gulimall.service.order.OrderSettingService;
import io.gulimall.utils.PageUtils;
import io.gulimall.utils.R;
@RestController
@RequestMapping("order/ordersetting")
public class OrderSettingController {

@Autowired
 private  OrderSettingService orderSettingService;


@RequestMapping("/save")
public R save(OrderSettingEntity orderSetting){
    orderSettingService.save(orderSetting);
    return R.ok();
}


@RequestMapping("/update")
public R update(OrderSettingEntity orderSetting){
    orderSettingService.updateById(orderSetting);
    return R.ok();
}


@RequestMapping("/list")
public R list(Map<String,Object> params){
    PageUtils page = orderSettingService.queryPage(params);
    return R.ok().put("page", page);
}


@RequestMapping("/delete")
public R delete(Long[] ids){
    orderSettingService.removeByIds(Arrays.asList(ids));
    return R.ok();
}


@RequestMapping("/info/{id}")
public R info(Long id){
    OrderSettingEntity orderSetting = orderSettingService.getById(id);
    return R.ok().put("orderSetting", orderSetting);
}


}