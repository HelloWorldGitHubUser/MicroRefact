package io.gulimall.service.coupon;
 import com.baomidou.mybatisplus.extension.service.IService;
import io.gulimall.to.SkuReductionTo;
import io.gulimall.utils.PageUtils;
import io.gulimall.entity.coupon.SkuFullReductionEntity;
import java.util.Map;
public interface SkuFullReductionService extends IService<SkuFullReductionEntity>{


public void saveSkuReductionTo(SkuReductionTo skuReductionTo)
;

public PageUtils queryPage(Map<String,Object> params)
;

}