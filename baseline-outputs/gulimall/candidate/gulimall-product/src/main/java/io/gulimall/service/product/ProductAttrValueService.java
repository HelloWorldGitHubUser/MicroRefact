package io.gulimall.service.product;
 import com.baomidou.mybatisplus.extension.service.IService;
import io.gulimall.utils.PageUtils;
import io.gulimall.entity.product.ProductAttrValueEntity;
import io.gulimall.vo.product.SpuItemAttrGroupVo;
import java.util.List;
import java.util.Map;
public interface ProductAttrValueService extends IService<ProductAttrValueEntity>{


public List<SpuItemAttrGroupVo> getProductGroupAttrsBySpuId(Long spuId,Long catalogId)
;

public PageUtils queryPage(Map<String,Object> params)
;

}