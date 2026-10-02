package io.gulimall.service.product;
 import com.baomidou.mybatisplus.extension.service.IService;
import io.gulimall.utils.PageUtils;
import io.gulimall.entity.product.SpuInfoEntity;
import io.gulimall.vo.product.SpuSaveVo;
import java.util.Map;
public interface SpuInfoService extends IService<SpuInfoEntity>{


public void upSpuForSearch(Long spuId)
;

public PageUtils queryPage(Map<String,Object> params)
;

public void saveSpuSaveVo(SpuSaveVo spuSaveVo)
;

public SpuInfoEntity getSpuBySkuId(Long skuId)
;

public PageUtils queryPageByCondition(Map<String,Object> params)
;

}