package io.gulimall.controller.coupon;
 import java.util.Arrays;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import io.gulimall.entity.coupon.CouponEntity;
import io.gulimall.service.coupon.CouponService;
import io.gulimall.utils.PageUtils;
import io.gulimall.utils.R;
import io.gulimall.DTO.R;
@RestController
@RequestMapping("coupon/coupon")
public class CouponController {

@Autowired
 private  CouponService couponService;

@Value("${coupon.user.name}")
 private  String name;

@Value("${coupon.user.age}")
 private  Integer age;


@RequestMapping("/member/list")
public R memberCoupons(){
    return R.ok().put("coupons", couponService.listMemberCoupons());
}


@RequestMapping("/save")
public R save(CouponEntity coupon){
    couponService.save(coupon);
    return R.ok();
}


@RequestMapping("/update")
public R update(CouponEntity coupon){
    couponService.updateById(coupon);
    return R.ok();
}


@RequestMapping("/list")
public R list(Map<String,Object> params){
    PageUtils page = couponService.queryPage(params);
    return R.ok().put("page", page);
}


@RequestMapping("/test")
public R getConfigInfo(){
    return R.ok().put("name", name).put("age", age);
}


@RequestMapping("/delete")
public R delete(Long[] ids){
    couponService.removeByIds(Arrays.asList(ids));
    return R.ok();
}


@RequestMapping("/info/{id}")
public R info(Long id){
    CouponEntity coupon = couponService.getById(id);
    return R.ok().put("coupon", coupon);
}


}