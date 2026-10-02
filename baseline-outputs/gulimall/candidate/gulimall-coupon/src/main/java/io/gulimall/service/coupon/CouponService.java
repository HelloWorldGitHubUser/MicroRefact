package io.gulimall.service.coupon;
 import com.baomidou.mybatisplus.extension.service.IService;
import io.gulimall.utils.PageUtils;
import io.gulimall.entity.coupon.CouponEntity;
import java.util.List;
import java.util.Map;
public interface CouponService extends IService<CouponEntity>{


public List<CouponEntity> listMemberCoupons()
;

public PageUtils queryPage(Map<String,Object> params)
;

}