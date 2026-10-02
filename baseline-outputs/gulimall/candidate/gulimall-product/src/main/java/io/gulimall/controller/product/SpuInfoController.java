package io.gulimall.controller.product;
 import java.util.Arrays;
import java.util.Map;
import io.gulimall.vo.product.SpuSaveVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation;
import io.gulimall.entity.product.SpuInfoEntity;
import io.gulimall.service.product.SpuInfoService;
import io.gulimall.utils.PageUtils;
import io.gulimall.utils.R;
@RestController
@RequestMapping("product/spuinfo")
public class SpuInfoController {

@Autowired
 private  SpuInfoService spuInfoService;


@PostMapping("/{spuId}/up")
public R upSpuForSearch(Long spuId){
    spuInfoService.upSpuForSearch(spuId);
    return R.ok();
}


@RequestMapping("/save")
public R save(SpuSaveVo spuSaveVo){
    spuInfoService.saveSpuSaveVo(spuSaveVo);
    return R.ok();
}


@RequestMapping("/update")
public R update(SpuInfoEntity spuInfo){
    spuInfoService.updateById(spuInfo);
    return R.ok();
}


@RequestMapping("/list")
public R list(Map<String,Object> params){
    PageUtils page = spuInfoService.queryPageByCondition(params);
    return R.ok().put("page", page);
}


@RequestMapping("/skuId/{skuId}")
public R getSpuBySkuId(Long skuId){
    SpuInfoEntity spuInfoEntity = spuInfoService.getSpuBySkuId(skuId);
    return R.ok().setData(spuInfoEntity);
}


@RequestMapping("/delete")
public R delete(Long[] ids){
    spuInfoService.removeByIds(Arrays.asList(ids));
    return R.ok();
}


@RequestMapping("/info/{id}")
public R info(Long id){
    SpuInfoEntity spuInfo = spuInfoService.getById(id);
    return R.ok().put("spuInfo", spuInfo);
}


}