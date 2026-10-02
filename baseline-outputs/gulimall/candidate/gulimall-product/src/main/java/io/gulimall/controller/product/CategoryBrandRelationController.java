package io.gulimall.controller.product;
 import java.util.Arrays;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation;
import io.gulimall.entity.product.CategoryBrandRelationEntity;
import io.gulimall.service.product.CategoryBrandRelationService;
import io.gulimall.utils.PageUtils;
import io.gulimall.utils.R;
@RestController
@RequestMapping("product/categorybrandrelation")
public class CategoryBrandRelationController {

@Autowired
 private  CategoryBrandRelationService categoryBrandRelationService;


@RequestMapping("catelog/list")
public R cateloglist(Long brandId){
    QueryWrapper<CategoryBrandRelationEntity> queryWrapper = new QueryWrapper<>();
    queryWrapper.eq("brand_id", brandId);
    List<CategoryBrandRelationEntity> data = categoryBrandRelationService.list(queryWrapper);
    return R.ok().put("data", data);
}


@GetMapping("/brands/list")
public R getBrandsByCategory(Long catelogId){
    List<CategoryBrandRelationEntity> entities = categoryBrandRelationService.getBrandsByCayId(catelogId);
    return R.ok().put("data", entities);
}


@RequestMapping("/save")
public R save(CategoryBrandRelationEntity categoryBrandRelation){
    // categoryBrandRelationService.save(categoryBrandRelation);
    categoryBrandRelationService.saveDetail(categoryBrandRelation);
    return R.ok();
}


@RequestMapping("/update")
public R update(CategoryBrandRelationEntity categoryBrandRelation){
    categoryBrandRelationService.updateById(categoryBrandRelation);
    return R.ok();
}


@RequestMapping("/list")
public R list(Map<String,Object> params){
    PageUtils page = categoryBrandRelationService.queryPage(params);
    return R.ok().put("page", page);
}


@RequestMapping("/delete")
public R delete(Long[] ids){
    categoryBrandRelationService.removeByIds(Arrays.asList(ids));
    return R.ok();
}


@RequestMapping("/info/{id}")
public R info(Long id){
    CategoryBrandRelationEntity categoryBrandRelation = categoryBrandRelationService.getById(id);
    return R.ok().put("categoryBrandRelation", categoryBrandRelation);
}


}