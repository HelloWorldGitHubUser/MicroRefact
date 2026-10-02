package io.gulimall.controller.coupon;
 import java.util.Arrays;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import io.gulimall.entity.coupon.CouponSpuCategoryRelationEntity;
import io.gulimall.service.coupon.CouponSpuCategoryRelationService;
import io.gulimall.utils.PageUtils;
import io.gulimall.utils.R;
@RestController
@RequestMapping("coupon/couponspucategoryrelation")
public class CouponSpuCategoryRelationController {

@Autowired
 private  CouponSpuCategoryRelationService couponSpuCategoryRelationService;


@RequestMapping("/save")
public R save(CouponSpuCategoryRelationEntity couponSpuCategoryRelation){
    couponSpuCategoryRelationService.save(couponSpuCategoryRelation);
    return R.ok();
}


@RequestMapping("/update")
public R update(CouponSpuCategoryRelationEntity couponSpuCategoryRelation){
    couponSpuCategoryRelationService.updateById(couponSpuCategoryRelation);
    return R.ok();
}


@RequestMapping("/list")
public R list(Map<String,Object> params){
    PageUtils page = couponSpuCategoryRelationService.queryPage(params);
    return R.ok().put("page", page);
}


@RequestMapping("/delete")
public R delete(Long[] ids){
    couponSpuCategoryRelationService.removeByIds(Arrays.asList(ids));
    return R.ok();
}


@RequestMapping("/info/{id}")
public R info(Long id){
    CouponSpuCategoryRelationEntity couponSpuCategoryRelation = couponSpuCategoryRelationService.getById(id);
    return R.ok().put("couponSpuCategoryRelation", couponSpuCategoryRelation);
}


}