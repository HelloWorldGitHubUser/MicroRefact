package io.gulimall.dao.product;
 import io.gulimall.entity.product.CategoryBrandRelationEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface CategoryBrandRelationDao extends BaseMapper<CategoryBrandRelationEntity>{


public void updateBrand(Long brandId,String name)
;

}