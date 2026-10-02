package io.gulimall.controller.coupon;
 import java.util.Arrays;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import io.gulimall.entity.coupon.CouponHistoryEntity;
import io.gulimall.service.coupon.CouponHistoryService;
import io.gulimall.utils.PageUtils;
import io.gulimall.utils.R;
@RestController
@RequestMapping("coupon/couponhistory")
public class CouponHistoryController {

@Autowired
 private  CouponHistoryService couponHistoryService;


@RequestMapping("/save")
public R save(CouponHistoryEntity couponHistory){
    couponHistoryService.save(couponHistory);
    return R.ok();
}


@RequestMapping("/update")
public R update(CouponHistoryEntity couponHistory){
    couponHistoryService.updateById(couponHistory);
    return R.ok();
}


@RequestMapping("/list")
public R list(Map<String,Object> params){
    PageUtils page = couponHistoryService.queryPage(params);
    return R.ok().put("page", page);
}


@RequestMapping("/delete")
public R delete(Long[] ids){
    couponHistoryService.removeByIds(Arrays.asList(ids));
    return R.ok();
}


@RequestMapping("/info/{id}")
public R info(Long id){
    CouponHistoryEntity couponHistory = couponHistoryService.getById(id);
    return R.ok().put("couponHistory", couponHistory);
}


}