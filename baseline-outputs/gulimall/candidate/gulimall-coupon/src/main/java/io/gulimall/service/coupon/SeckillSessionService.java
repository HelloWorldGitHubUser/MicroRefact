package io.gulimall.service.coupon;
 import com.baomidou.mybatisplus.extension.service.IService;
import io.gulimall.utils.PageUtils;
import io.gulimall.entity.coupon.SeckillSessionEntity;
import java.util.List;
import java.util.Map;
public interface SeckillSessionService extends IService<SeckillSessionEntity>{


public List<SeckillSessionEntity> getSeckillSessionsIn3Days()
;

public PageUtils queryPage(Map<String,Object> params)
;

}