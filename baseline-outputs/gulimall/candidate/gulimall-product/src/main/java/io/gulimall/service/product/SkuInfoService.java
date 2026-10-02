package io.gulimall.service.product;
 import com.baomidou.mybatisplus.extension.service.IService;
import io.gulimall.utils.PageUtils;
import io.gulimall.entity.product.SkuInfoEntity;
import io.gulimall.vo.product.SkuItemVo;
import java.util.List;
import java.util.Map;
public interface SkuInfoService extends IService<SkuInfoEntity>{


public SkuItemVo item(Long skuId)
;

public PageUtils queryPage(Map<String,Object> params)
;

public PageUtils queryPageByCondition(Map<String,Object> params)
;

public List<SkuInfoEntity> getSkusBySpuId(Long spuId)
;

}