package io.gulimall.controller.order;
 import java.util.Arrays;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import io.gulimall.entity.order.OrderReturnApplyEntity;
import io.gulimall.service.order.OrderReturnApplyService;
import io.gulimall.utils.PageUtils;
import io.gulimall.utils.R;
@RestController
@RequestMapping("order/orderreturnapply")
public class OrderReturnApplyController {

@Autowired
 private  OrderReturnApplyService orderReturnApplyService;


@RequestMapping("/save")
public R save(OrderReturnApplyEntity orderReturnApply){
    orderReturnApplyService.save(orderReturnApply);
    return R.ok();
}


@RequestMapping("/update")
public R update(OrderReturnApplyEntity orderReturnApply){
    orderReturnApplyService.updateById(orderReturnApply);
    return R.ok();
}


@RequestMapping("/list")
public R list(Map<String,Object> params){
    PageUtils page = orderReturnApplyService.queryPage(params);
    return R.ok().put("page", page);
}


@RequestMapping("/delete")
public R delete(Long[] ids){
    orderReturnApplyService.removeByIds(Arrays.asList(ids));
    return R.ok();
}


@RequestMapping("/info/{id}")
public R info(Long id){
    OrderReturnApplyEntity orderReturnApply = orderReturnApplyService.getById(id);
    return R.ok().put("orderReturnApply", orderReturnApply);
}


}