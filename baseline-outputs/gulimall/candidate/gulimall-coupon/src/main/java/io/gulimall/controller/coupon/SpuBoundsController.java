package io.gulimall.controller.coupon;
 import java.util.Arrays;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import io.gulimall.entity.coupon.SpuBoundsEntity;
import io.gulimall.service.coupon.SpuBoundsService;
import io.gulimall.utils.PageUtils;
import io.gulimall.utils.R;
@RestController
@RequestMapping("coupon/spubounds")
public class SpuBoundsController {

@Autowired
 private  SpuBoundsService spuBoundsService;


@RequestMapping("/save")
public R save(SpuBoundsEntity spuBounds){
    spuBoundsService.save(spuBounds);
    return R.ok();
}


@RequestMapping("/update")
public R update(SpuBoundsEntity spuBounds){
    spuBoundsService.updateById(spuBounds);
    return R.ok();
}


@RequestMapping("/list")
public R list(Map<String,Object> params){
    PageUtils page = spuBoundsService.queryPage(params);
    return R.ok().put("page", page);
}


@RequestMapping("/delete")
public R delete(Long[] ids){
    spuBoundsService.removeByIds(Arrays.asList(ids));
    return R.ok();
}


@RequestMapping("/info/{id}")
public R info(Long id){
    SpuBoundsEntity spuBounds = spuBoundsService.getById(id);
    return R.ok().put("spuBounds", spuBounds);
}


}