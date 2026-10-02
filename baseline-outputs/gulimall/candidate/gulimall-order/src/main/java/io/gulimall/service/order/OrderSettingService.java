package io.gulimall.service.order;
 import com.baomidou.mybatisplus.extension.service.IService;
import io.gulimall.utils.PageUtils;
import io.gulimall.entity.order.OrderSettingEntity;
import java.util.Map;
public interface OrderSettingService extends IService<OrderSettingEntity>{


public PageUtils queryPage(Map<String,Object> params)
;

}