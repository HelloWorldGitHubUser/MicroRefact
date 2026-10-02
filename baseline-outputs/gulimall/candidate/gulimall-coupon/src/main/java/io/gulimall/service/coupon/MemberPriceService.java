package io.gulimall.service.coupon;
 import com.baomidou.mybatisplus.extension.service.IService;
import io.gulimall.utils.PageUtils;
import io.gulimall.entity.coupon.MemberPriceEntity;
import java.util.Map;
public interface MemberPriceService extends IService<MemberPriceEntity>{


public PageUtils queryPage(Map<String,Object> params)
;

}