package io.gulimall.service.product;
 import com.baomidou.mybatisplus.extension.service.IService;
import io.gulimall.utils.PageUtils;
import io.gulimall.entity.product.CategoryBrandRelationEntity;
import io.gulimall.entity.product.CategoryEntity;
import java.util.List;
import java.util.Map;
public interface CategoryBrandRelationService extends IService<CategoryBrandRelationEntity>{


public void saveDetail(CategoryBrandRelationEntity categoryBrandRelation)
;

public void updateBrand(Long brandId,String name)
;

public void updateCategory(CategoryEntity category)
;

public PageUtils queryPage(Map<String,Object> params)
;

public List<CategoryBrandRelationEntity> getBrandsByCayId(Long catelogId)
;

}