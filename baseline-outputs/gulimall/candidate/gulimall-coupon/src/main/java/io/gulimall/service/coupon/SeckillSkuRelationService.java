package io.gulimall.service.coupon;
 import com.baomidou.mybatisplus.extension.service.IService;
import io.gulimall.utils.PageUtils;
import io.gulimall.entity.coupon.SeckillSkuRelationEntity;
import java.util.Map;
public interface SeckillSkuRelationService extends IService<SeckillSkuRelationEntity>{


public PageUtils queryPage(Map<String,Object> params)
;

}