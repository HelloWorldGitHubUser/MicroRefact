package io.gulimall.controller.product;
 import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation;
import io.gulimall.entity.product.SkuSaleAttrValueEntity;
import io.gulimall.service.product.SkuSaleAttrValueService;
import io.gulimall.utils.PageUtils;
import io.gulimall.utils.R;
@RestController
@RequestMapping("product/skusaleattrvalue")
public class SkuSaleAttrValueController {

@Autowired
 private  SkuSaleAttrValueService skuSaleAttrValueService;


@RequestMapping("/getSkuSaleAttrValuesAsString")
public List<String> getSkuSaleAttrValuesAsString(Long skuId){
    return skuSaleAttrValueService.getSkuSaleAttrValuesAsString(skuId);
}


@RequestMapping("/save")
public R save(SkuSaleAttrValueEntity skuSaleAttrValue){
    skuSaleAttrValueService.save(skuSaleAttrValue);
    return R.ok();
}


@RequestMapping("/update")
public R update(SkuSaleAttrValueEntity skuSaleAttrValue){
    skuSaleAttrValueService.updateById(skuSaleAttrValue);
    return R.ok();
}


@RequestMapping("/list")
public R list(Map<String,Object> params){
    PageUtils page = skuSaleAttrValueService.queryPage(params);
    return R.ok().put("page", page);
}


@RequestMapping("/delete")
public R delete(Long[] ids){
    skuSaleAttrValueService.removeByIds(Arrays.asList(ids));
    return R.ok();
}


@RequestMapping("/info/{id}")
public R info(Long id){
    SkuSaleAttrValueEntity skuSaleAttrValue = skuSaleAttrValueService.getById(id);
    return R.ok().put("skuSaleAttrValue", skuSaleAttrValue);
}


}