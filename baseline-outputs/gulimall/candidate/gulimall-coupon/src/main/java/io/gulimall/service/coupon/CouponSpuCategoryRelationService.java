package io.gulimall.service.coupon;
 import com.baomidou.mybatisplus.extension.service.IService;
import io.gulimall.utils.PageUtils;
import io.gulimall.entity.coupon.CouponSpuCategoryRelationEntity;
import java.util.Map;
public interface CouponSpuCategoryRelationService extends IService<CouponSpuCategoryRelationEntity>{


public PageUtils queryPage(Map<String,Object> params)
;

}