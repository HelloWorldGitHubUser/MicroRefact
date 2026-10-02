package io.gulimall.service.coupon;
 import com.baomidou.mybatisplus.extension.service.IService;
import io.gulimall.utils.PageUtils;
import io.gulimall.entity.coupon.SpuBoundsEntity;
import java.util.Map;
public interface SpuBoundsService extends IService<SpuBoundsEntity>{


public PageUtils queryPage(Map<String,Object> params)
;

}