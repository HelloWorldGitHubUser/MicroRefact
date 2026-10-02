package io.gulimall.service.order;
 import com.baomidou.mybatisplus.extension.service.IService;
import io.gulimall.utils.PageUtils;
import io.gulimall.entity.order.OrderItemEntity;
import java.util.Map;
public interface OrderItemService extends IService<OrderItemEntity>{


public PageUtils queryPage(Map<String,Object> params)
;

}