package io.gulimall.controller.coupon;
 import java.util.Arrays;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import io.gulimall.entity.coupon.CouponSpuRelationEntity;
import io.gulimall.service.coupon.CouponSpuRelationService;
import io.gulimall.utils.PageUtils;
import io.gulimall.utils.R;
@RestController
@RequestMapping("coupon/couponspurelation")
public class CouponSpuRelationController {

@Autowired
 private  CouponSpuRelationService couponSpuRelationService;


@RequestMapping("/save")
public R save(CouponSpuRelationEntity couponSpuRelation){
    couponSpuRelationService.save(couponSpuRelation);
    return R.ok();
}


@RequestMapping("/update")
public R update(CouponSpuRelationEntity couponSpuRelation){
    couponSpuRelationService.updateById(couponSpuRelation);
    return R.ok();
}


@RequestMapping("/list")
public R list(Map<String,Object> params){
    PageUtils page = couponSpuRelationService.queryPage(params);
    return R.ok().put("page", page);
}


@RequestMapping("/delete")
public R delete(Long[] ids){
    couponSpuRelationService.removeByIds(Arrays.asList(ids));
    return R.ok();
}


@RequestMapping("/info/{id}")
public R info(Long id){
    CouponSpuRelationEntity couponSpuRelation = couponSpuRelationService.getById(id);
    return R.ok().put("couponSpuRelation", couponSpuRelation);
}


}