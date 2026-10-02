package io.gulimall.controller.coupon;
 import java.util.Arrays;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import io.gulimall.entity.coupon.SkuLadderEntity;
import io.gulimall.service.coupon.SkuLadderService;
import io.gulimall.utils.PageUtils;
import io.gulimall.utils.R;
@RestController
@RequestMapping("coupon/skuladder")
public class SkuLadderController {

@Autowired
 private  SkuLadderService skuLadderService;


@RequestMapping("/save")
public R save(SkuLadderEntity skuLadder){
    skuLadderService.save(skuLadder);
    return R.ok();
}


@RequestMapping("/update")
public R update(SkuLadderEntity skuLadder){
    skuLadderService.updateById(skuLadder);
    return R.ok();
}


@RequestMapping("/list")
public R list(Map<String,Object> params){
    PageUtils page = skuLadderService.queryPage(params);
    return R.ok().put("page", page);
}


@RequestMapping("/delete")
public R delete(Long[] ids){
    skuLadderService.removeByIds(Arrays.asList(ids));
    return R.ok();
}


@RequestMapping("/info/{id}")
public R info(Long id){
    SkuLadderEntity skuLadder = skuLadderService.getById(id);
    return R.ok().put("skuLadder", skuLadder);
}


}