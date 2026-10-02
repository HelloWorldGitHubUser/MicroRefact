package io.gulimall.controller.order;
 import java.util.Arrays;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import io.gulimall.entity.order.PaymentInfoEntity;
import io.gulimall.service.order.PaymentInfoService;
import io.gulimall.utils.PageUtils;
import io.gulimall.utils.R;
@RestController
@RequestMapping("order/paymentinfo")
public class PaymentInfoController {

@Autowired
 private  PaymentInfoService paymentInfoService;


@RequestMapping("/save")
public R save(PaymentInfoEntity paymentInfo){
    paymentInfoService.save(paymentInfo);
    return R.ok();
}


@RequestMapping("/update")
public R update(PaymentInfoEntity paymentInfo){
    paymentInfoService.updateById(paymentInfo);
    return R.ok();
}


@RequestMapping("/list")
public R list(Map<String,Object> params){
    PageUtils page = paymentInfoService.queryPage(params);
    return R.ok().put("page", page);
}


@RequestMapping("/delete")
public R delete(Long[] ids){
    paymentInfoService.removeByIds(Arrays.asList(ids));
    return R.ok();
}


@RequestMapping("/info/{id}")
public R info(Long id){
    PaymentInfoEntity paymentInfo = paymentInfoService.getById(id);
    return R.ok().put("paymentInfo", paymentInfo);
}


}