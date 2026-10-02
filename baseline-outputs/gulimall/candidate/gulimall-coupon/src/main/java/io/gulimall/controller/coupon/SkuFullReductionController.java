package io.gulimall.controller.coupon;
 import java.util.Arrays;
import java.util.Map;
import io.gulimall.to.SkuReductionTo;
import io.gulimall.service.coupon.SkuLadderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation;
import io.gulimall.entity.coupon.SkuFullReductionEntity;
import io.gulimall.service.coupon.SkuFullReductionService;
import io.gulimall.utils.PageUtils;
import io.gulimall.utils.R;
@RestController
@RequestMapping("coupon/skufullreduction")
public class SkuFullReductionController {

@Autowired
 private  SkuFullReductionService skuFullReductionService;

@Autowired
 private  SkuLadderService skuLadderService;


@RequestMapping("/save")
public R save(SkuFullReductionEntity skuFullReduction){
    skuFullReductionService.save(skuFullReduction);
    return R.ok();
}


@PostMapping("/saveInfo")
public R saveSkuReductionTo(SkuReductionTo skuReductionTo){
    skuFullReductionService.saveSkuReductionTo(skuReductionTo);
    return R.ok();
}


@RequestMapping("/update")
public R update(SkuFullReductionEntity skuFullReduction){
    skuFullReductionService.updateById(skuFullReduction);
    return R.ok();
}


@RequestMapping("/list")
public R list(Map<String,Object> params){
    PageUtils page = skuFullReductionService.queryPage(params);
    return R.ok().put("page", page);
}


@RequestMapping("/delete")
public R delete(Long[] ids){
    skuFullReductionService.removeByIds(Arrays.asList(ids));
    return R.ok();
}


@RequestMapping("/info/{id}")
public R info(Long id){
    SkuFullReductionEntity skuFullReduction = skuFullReductionService.getById(id);
    return R.ok().put("skuFullReduction", skuFullReduction);
}


}