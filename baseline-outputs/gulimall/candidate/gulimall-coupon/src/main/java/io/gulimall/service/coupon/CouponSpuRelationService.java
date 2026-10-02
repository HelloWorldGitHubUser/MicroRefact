package io.gulimall.service.coupon;
 import com.baomidou.mybatisplus.extension.service.IService;
import io.gulimall.utils.PageUtils;
import io.gulimall.entity.coupon.CouponSpuRelationEntity;
import java.util.Map;
public interface CouponSpuRelationService extends IService<CouponSpuRelationEntity>{


public PageUtils queryPage(Map<String,Object> params)
;

}