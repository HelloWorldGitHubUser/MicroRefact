package io.gulimall.controller.coupon;
 import java.util.Arrays;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import io.gulimall.entity.coupon.SeckillSkuRelationEntity;
import io.gulimall.service.coupon.SeckillSkuRelationService;
import io.gulimall.utils.PageUtils;
import io.gulimall.utils.R;
@RestController
@RequestMapping("coupon/seckillskurelation")
public class SeckillSkuRelationController {

@Autowired
 private  SeckillSkuRelationService seckillSkuRelationService;


@RequestMapping("/save")
public R save(SeckillSkuRelationEntity seckillSkuRelation){
    seckillSkuRelationService.save(seckillSkuRelation);
    return R.ok();
}


@RequestMapping("/update")
public R update(SeckillSkuRelationEntity seckillSkuRelation){
    seckillSkuRelationService.updateById(seckillSkuRelation);
    return R.ok();
}


@RequestMapping("/list")
public R list(Map<String,Object> params){
    PageUtils page = seckillSkuRelationService.queryPage(params);
    return R.ok().put("page", page);
}


@RequestMapping("/delete")
public R delete(Long[] ids){
    seckillSkuRelationService.removeByIds(Arrays.asList(ids));
    return R.ok();
}


@RequestMapping("/info/{id}")
public R info(Long id){
    SeckillSkuRelationEntity seckillSkuRelation = seckillSkuRelationService.getById(id);
    return R.ok().put("seckillSkuRelation", seckillSkuRelation);
}


}