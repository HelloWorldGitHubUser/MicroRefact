package io.gulimall.service.coupon;
 import com.baomidou.mybatisplus.extension.service.IService;
import io.gulimall.utils.PageUtils;
import io.gulimall.entity.coupon.SeckillSkuNoticeEntity;
import java.util.Map;
public interface SeckillSkuNoticeService extends IService<SeckillSkuNoticeEntity>{


public PageUtils queryPage(Map<String,Object> params)
;

}