package io.gulimall.controller.product;
 import java.util.Arrays;
import java.util.Map;
import io.gulimall.group.AddGroup;
import io.gulimall.group.UpdateGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import io.gulimall.entity.product.BrandEntity;
import io.gulimall.service.product.BrandService;
import io.gulimall.utils.PageUtils;
import io.gulimall.utils.R;
@RestController
@RequestMapping("product/brand")
public class BrandController {

@Autowired
 private  BrandService brandService;


@RequestMapping("/save")
public R save(BrandEntity brand)/*, BindingResult result*/
{
    brandService.save(brand);
    return R.ok();
// if (result.hasErrors()){
// Map<String, String> map = new HashMap<>();
// result.getFieldErrors().forEach((item)->{
// String message = item.getDefaultMessage();
// String field = item.getField();
// map.put(message, field);
// });
// return R.error(400, "提交的数据不合法").put("data", map);
// }else {
// brandService.save(brand);
// return R.ok();
// }
}


@RequestMapping("/update")
public R update(BrandEntity brand){
    // brandService.updateById(brand);
    // 级联更新所有数据
    brandService.updateCascade(brand);
    return R.ok();
}


@RequestMapping("/list")
public R list(Map<String,Object> params){
    PageUtils page = brandService.queryPage(params);
    return R.ok().put("page", page);
}


@RequestMapping("/delete")
public R delete(Long[] brandIds){
    brandService.removeByIds(Arrays.asList(brandIds));
    return R.ok();
}


@RequestMapping("/info/{brandId}")
public R info(Long brandId){
    BrandEntity brand = brandService.getById(brandId);
    return R.ok().put("brand", brand);
}


}