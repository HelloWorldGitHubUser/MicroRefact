package io.gulimall.service.order;
 import com.baomidou.mybatisplus.extension.service.IService;
import io.gulimall.utils.PageUtils;
import io.gulimall.entity.order.OrderOperateHistoryEntity;
import java.util.Map;
public interface OrderOperateHistoryService extends IService<OrderOperateHistoryEntity>{


public PageUtils queryPage(Map<String,Object> params)
;

}