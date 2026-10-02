package io.gulimall.controller.product;
 import java.util.Arrays;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import io.gulimall.entity.product.SpuImagesEntity;
import io.gulimall.service.product.SpuImagesService;
import io.gulimall.utils.PageUtils;
import io.gulimall.utils.R;
@RestController
@RequestMapping("product/spuimages")
public class SpuImagesController {

@Autowired
 private  SpuImagesService spuImagesService;


@RequestMapping("/save")
public R save(SpuImagesEntity spuImages){
    spuImagesService.save(spuImages);
    return R.ok();
}


@RequestMapping("/update")
public R update(SpuImagesEntity spuImages){
    spuImagesService.updateById(spuImages);
    return R.ok();
}


@RequestMapping("/list")
public R list(Map<String,Object> params){
    PageUtils page = spuImagesService.queryPage(params);
    return R.ok().put("page", page);
}


@RequestMapping("/delete")
public R delete(Long[] ids){
    spuImagesService.removeByIds(Arrays.asList(ids));
    return R.ok();
}


@RequestMapping("/info/{id}")
public R info(Long id){
    SpuImagesEntity spuImages = spuImagesService.getById(id);
    return R.ok().put("spuImages", spuImages);
}


}