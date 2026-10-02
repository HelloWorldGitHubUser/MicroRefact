package io.gulimall.controller.product;
 import java.util.Arrays;
import java.util.List;
import java.util.Map;
import io.gulimall.entity.product.ProductAttrValueEntity;
import io.gulimall.vo.product.AttrRespVo;
import io.gulimall.vo.product.AttrVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation;
import io.gulimall.service.product.AttrService;
import io.gulimall.utils.PageUtils;
import io.gulimall.utils.R;
@RestController
@RequestMapping("product/attr")
public class AttrController {

@Autowired
 private  AttrService attrService;


@GetMapping("/hello")
public String helloTest(){
    return "hello";
}


@GetMapping("/base/listforspu/{spuId}")
public R listAttrsforSpu(Long spuId){
    List<ProductAttrValueEntity> productAttrValueEntities = attrService.listAttrsforSpu(spuId);
    return R.ok().put("data", productAttrValueEntities);
}


@PostMapping("/update/{spuId}")
public R updateSpuAttrs(Long spuId,List<ProductAttrValueEntity> attrValueEntities){
    attrService.updateSpuAttrs(spuId, attrValueEntities);
    return R.ok();
}


@RequestMapping("/save")
public R save(AttrVo attr){
    attrService.saveAttr(attr);
    return R.ok();
}


@RequestMapping("/update")
public R update(AttrVo attr){
    // attrService.updateById(attr);
    attrService.updateAttr(attr);
    return R.ok();
}


@RequestMapping("/{attrType}/list/{catelogId}")
public R infoCatelog(Map<String,Object> params,long catelogId,String attrType){
    PageUtils page = attrService.queryPage(params, catelogId, attrType);
    return R.ok().put("page", page);
}


@RequestMapping("/delete")
public R delete(Long[] attrIds){
    attrService.removeByIds(Arrays.asList(attrIds));
    return R.ok();
}


@RequestMapping("/info/{attrId}")
public R info(Long attrId){
    AttrRespVo respVo = attrService.getAttrInfo(attrId);
    return R.ok().put("attr", respVo);
}


}