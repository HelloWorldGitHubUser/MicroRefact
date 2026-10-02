package com.youlai.mall.service.sms;
 import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.youlai.mall.model.sms.entity.SmsCoupon;
import com.baomidou.mybatisplus.extension.service.IService;
import com.youlai.mall.model.sms.form.CouponForm;
import com.youlai.mall.model.sms.query.CouponPageQuery;
import com.youlai.mall.model.sms.vo.CouponPageVO;
public interface SmsCouponService extends IService<SmsCoupon>{


public boolean saveCoupon(CouponForm couponForm)
;

public boolean deleteCoupons(String ids)
;

public CouponForm getCouponFormData(Long couponId)
;

public boolean updateCoupon(Long couponId,CouponForm couponForm)
;

public Page<CouponPageVO> getCouponPage(CouponPageQuery queryParams)
;

}