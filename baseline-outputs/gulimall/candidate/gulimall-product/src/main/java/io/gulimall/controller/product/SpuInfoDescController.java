package io.gulimall.controller.product;
 import java.util.Arrays;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import io.gulimall.entity.product.SpuInfoDescEntity;
import io.gulimall.service.product.SpuInfoDescService;
import io.gulimall.utils.PageUtils;
import io.gulimall.utils.R;
@RestController
@RequestMapping("product/spuinfodesc")
public class SpuInfoDescController {

@Autowired
 private  SpuInfoDescService spuInfoDescService;


@RequestMapping("/save")
public R save(SpuInfoDescEntity spuInfoDesc){
    spuInfoDescService.save(spuInfoDesc);
    return R.ok();
}


@RequestMapping("/update")
public R update(SpuInfoDescEntity spuInfoDesc){
    spuInfoDescService.updateById(spuInfoDesc);
    return R.ok();
}


@RequestMapping("/list")
public R list(Map<String,Object> params){
    PageUtils page = spuInfoDescService.queryPage(params);
    return R.ok().put("page", page);
}


@RequestMapping("/delete")
public R delete(Long[] spuIds){
    spuInfoDescService.removeByIds(Arrays.asList(spuIds));
    return R.ok();
}


@RequestMapping("/info/{spuId}")
public R info(Long spuId){
    SpuInfoDescEntity spuInfoDesc = spuInfoDescService.getById(spuId);
    return R.ok().put("spuInfoDesc", spuInfoDesc);
}


}