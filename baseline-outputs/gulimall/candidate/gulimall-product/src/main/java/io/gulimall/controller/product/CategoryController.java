package io.gulimall.controller.product;
 import java.util.Arrays;
import java.util.List;
import java.util.Map;
import io.gulimall.service.product.CategoryBrandRelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import io.gulimall.entity.product.CategoryEntity;
import io.gulimall.service.product.CategoryService;
import io.gulimall.utils.PageUtils;
import io.gulimall.utils.R;
@RestController
@RequestMapping("product/category")
public class CategoryController {

@Autowired
 private  CategoryService categoryService;

@Autowired
 private  CategoryBrandRelationService categoryBrandRelationService;


@RequestMapping("/save")
public R save(CategoryEntity category){
    categoryService.save(category);
    return R.ok();
}


@RequestMapping("/updateNodes")
public R update(CategoryEntity[] categorys){
    categoryService.updateBatchById(Arrays.asList(categorys));
    return R.ok();
}


@RequestMapping("/list")
public R list(Map<String,Object> params){
    PageUtils page = categoryService.queryPage(params);
    return R.ok().put("page", page);
}


@RequestMapping("/delete")
public R delete(Long[] catIds){
    // 删除之前需要判断待删除的菜单那是否被别的地方所引用。
    // categoryService.removeByIds(Arrays.asList(catIds));
    categoryService.removeMenuByIds(Arrays.asList(catIds));
    return R.ok();
}


@RequestMapping("/info/{catId}")
public R info(Long catId){
    CategoryEntity category = categoryService.getById(catId);
    return R.ok().put("category", category);
}


}