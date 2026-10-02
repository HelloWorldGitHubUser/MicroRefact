package io.gulimall.service.product;
 import com.baomidou.mybatisplus.extension.service.IService;
import io.gulimall.utils.PageUtils;
import io.gulimall.entity.product.SkuSaleAttrValueEntity;
import io.gulimall.vo.product.SkuItemSaleAttrVo;
import java.util.List;
import java.util.Map;
public interface SkuSaleAttrValueService extends IService<SkuSaleAttrValueEntity>{


public List<SkuItemSaleAttrVo> listSaleAttrs(Long spuId)
;

public List<String> getSkuSaleAttrValuesAsString(Long skuId)
;

public PageUtils queryPage(Map<String,Object> params)
;

}