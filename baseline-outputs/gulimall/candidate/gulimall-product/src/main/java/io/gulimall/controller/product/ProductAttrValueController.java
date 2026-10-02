package io.gulimall.controller.product;
 import java.util.Arrays;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import io.gulimall.entity.product.ProductAttrValueEntity;
import io.gulimall.service.product.ProductAttrValueService;
import io.gulimall.utils.PageUtils;
import io.gulimall.utils.R;
@RestController
@RequestMapping("product/productattrvalue")
public class ProductAttrValueController {

@Autowired
 private  ProductAttrValueService productAttrValueService;


@RequestMapping("/save")
public R save(ProductAttrValueEntity productAttrValue){
    productAttrValueService.save(productAttrValue);
    return R.ok();
}


@RequestMapping("/update")
public R update(ProductAttrValueEntity productAttrValue){
    productAttrValueService.updateById(productAttrValue);
    return R.ok();
}


@RequestMapping("/list")
public R list(Map<String,Object> params){
    PageUtils page = productAttrValueService.queryPage(params);
    return R.ok().put("page", page);
}


@RequestMapping("/delete")
public R delete(Long[] ids){
    productAttrValueService.removeByIds(Arrays.asList(ids));
    return R.ok();
}


@RequestMapping("/info/{id}")
public R info(Long id){
    ProductAttrValueEntity productAttrValue = productAttrValueService.getById(id);
    return R.ok().put("productAttrValue", productAttrValue);
}


}