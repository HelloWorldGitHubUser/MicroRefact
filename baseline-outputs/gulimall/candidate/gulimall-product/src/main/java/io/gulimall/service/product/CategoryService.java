package io.gulimall.service.product;
 import com.baomidou.mybatisplus.extension.service.IService;
import io.gulimall.utils.PageUtils;
import io.gulimall.entity.product.CategoryEntity;
import io.gulimall.vo.product.Catalog2Vo;
import java.util.List;
import java.util.Map;
public interface CategoryService extends IService<CategoryEntity>{


public Map<String,List<Catalog2Vo>> getCatalogJsonDbWithSpringCache()
;

public List<CategoryEntity> listWithTree()
;

public Map<String,List<Catalog2Vo>> getCategoryMap()
;

public void removeMenuByIds(List<Long> asList)
;

public PageUtils queryPage(Map<String,Object> params)
;

public void updateCascade(CategoryEntity category)
;

public List<CategoryEntity> getLevel1Catagories()
;

public Long[] findCatelogPathById(Long categorygId)
;

}