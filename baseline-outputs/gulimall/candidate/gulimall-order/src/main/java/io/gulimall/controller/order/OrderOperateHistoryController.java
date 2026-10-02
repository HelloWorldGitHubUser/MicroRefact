package io.gulimall.controller.order;
 import java.util.Arrays;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import io.gulimall.entity.order.OrderOperateHistoryEntity;
import io.gulimall.service.order.OrderOperateHistoryService;
import io.gulimall.utils.PageUtils;
import io.gulimall.utils.R;
@RestController
@RequestMapping("order/orderoperatehistory")
public class OrderOperateHistoryController {

@Autowired
 private  OrderOperateHistoryService orderOperateHistoryService;


@RequestMapping("/save")
public R save(OrderOperateHistoryEntity orderOperateHistory){
    orderOperateHistoryService.save(orderOperateHistory);
    return R.ok();
}


@RequestMapping("/update")
public R update(OrderOperateHistoryEntity orderOperateHistory){
    orderOperateHistoryService.updateById(orderOperateHistory);
    return R.ok();
}


@RequestMapping("/list")
public R list(Map<String,Object> params){
    PageUtils page = orderOperateHistoryService.queryPage(params);
    return R.ok().put("page", page);
}


@RequestMapping("/delete")
public R delete(Long[] ids){
    orderOperateHistoryService.removeByIds(Arrays.asList(ids));
    return R.ok();
}


@RequestMapping("/info/{id}")
public R info(Long id){
    OrderOperateHistoryEntity orderOperateHistory = orderOperateHistoryService.getById(id);
    return R.ok().put("orderOperateHistory", orderOperateHistory);
}


}