package io.gulimall.controller.coupon;
 import java.util.Arrays;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import io.gulimall.entity.coupon.SeckillPromotionEntity;
import io.gulimall.service.coupon.SeckillPromotionService;
import io.gulimall.utils.PageUtils;
import io.gulimall.utils.R;
@RestController
@RequestMapping("coupon/seckillpromotion")
public class SeckillPromotionController {

@Autowired
 private  SeckillPromotionService seckillPromotionService;


@RequestMapping("/save")
public R save(SeckillPromotionEntity seckillPromotion){
    seckillPromotionService.save(seckillPromotion);
    return R.ok();
}


@RequestMapping("/update")
public R update(SeckillPromotionEntity seckillPromotion){
    seckillPromotionService.updateById(seckillPromotion);
    return R.ok();
}


@RequestMapping("/list")
public R list(Map<String,Object> params){
    PageUtils page = seckillPromotionService.queryPage(params);
    return R.ok().put("page", page);
}


@RequestMapping("/delete")
public R delete(Long[] ids){
    seckillPromotionService.removeByIds(Arrays.asList(ids));
    return R.ok();
}


@RequestMapping("/info/{id}")
public R info(Long id){
    SeckillPromotionEntity seckillPromotion = seckillPromotionService.getById(id);
    return R.ok().put("seckillPromotion", seckillPromotion);
}


}