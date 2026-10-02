package io.gulimall.controller.product;
 import java.util.Arrays;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import io.gulimall.entity.product.SkuInfoEntity;
import io.gulimall.service.product.SkuInfoService;
import io.gulimall.utils.PageUtils;
import io.gulimall.utils.R;
@RestController
@RequestMapping("product/skuinfo")
public class SkuInfoController {

@Autowired
 private  SkuInfoService skuInfoService;


@RequestMapping("/save")
public R save(SkuInfoEntity skuInfo){
    skuInfoService.save(skuInfo);
    return R.ok();
}


@RequestMapping("/update")
public R update(SkuInfoEntity skuInfo){
    skuInfoService.updateById(skuInfo);
    return R.ok();
}


@RequestMapping("/list")
public R list(Map<String,Object> params){
    PageUtils page = skuInfoService.queryPageByCondition(params);
    return R.ok().put("page", page);
}


@RequestMapping("/delete")
public R delete(Long[] skuIds){
    skuInfoService.removeByIds(Arrays.asList(skuIds));
    return R.ok();
}


@RequestMapping("/info/{skuId}")
public R info(Long skuId){
    SkuInfoEntity skuInfo = skuInfoService.getById(skuId);
    return R.ok().put("skuInfo", skuInfo);
}


}