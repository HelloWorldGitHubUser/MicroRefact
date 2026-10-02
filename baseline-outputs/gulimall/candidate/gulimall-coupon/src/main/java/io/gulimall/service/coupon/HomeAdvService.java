package io.gulimall.service.coupon;
 import com.baomidou.mybatisplus.extension.service.IService;
import io.gulimall.utils.PageUtils;
import io.gulimall.entity.coupon.HomeAdvEntity;
import java.util.Map;
public interface HomeAdvService extends IService<HomeAdvEntity>{


public PageUtils queryPage(Map<String,Object> params)
;

}