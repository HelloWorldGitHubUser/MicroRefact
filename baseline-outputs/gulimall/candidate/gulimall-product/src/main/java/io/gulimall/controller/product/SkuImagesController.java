package io.gulimall.controller.product;
 import java.util.Arrays;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import io.gulimall.entity.product.SkuImagesEntity;
import io.gulimall.service.product.SkuImagesService;
import io.gulimall.utils.PageUtils;
import io.gulimall.utils.R;
@RestController
@RequestMapping("product/skuimages")
public class SkuImagesController {

@Autowired
 private  SkuImagesService skuImagesService;


@RequestMapping("/save")
public R save(SkuImagesEntity skuImages){
    skuImagesService.save(skuImages);
    return R.ok();
}


@RequestMapping("/update")
public R update(SkuImagesEntity skuImages){
    skuImagesService.updateById(skuImages);
    return R.ok();
}


@RequestMapping("/list")
public R list(Map<String,Object> params){
    PageUtils page = skuImagesService.queryPage(params);
    return R.ok().put("page", page);
}


@RequestMapping("/delete")
public R delete(Long[] ids){
    skuImagesService.removeByIds(Arrays.asList(ids));
    return R.ok();
}


@RequestMapping("/info/{id}")
public R info(Long id){
    SkuImagesEntity skuImages = skuImagesService.getById(id);
    return R.ok().put("skuImages", skuImages);
}


}