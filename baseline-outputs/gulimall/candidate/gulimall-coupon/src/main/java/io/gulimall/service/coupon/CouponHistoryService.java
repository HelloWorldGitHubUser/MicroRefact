package io.gulimall.service.coupon;
 import com.baomidou.mybatisplus.extension.service.IService;
import io.gulimall.utils.PageUtils;
import io.gulimall.entity.coupon.CouponHistoryEntity;
import java.util.Map;
public interface CouponHistoryService extends IService<CouponHistoryEntity>{


public PageUtils queryPage(Map<String,Object> params)
;

}