package io.gulimall.service.order;
 import com.baomidou.mybatisplus.extension.service.IService;
import io.gulimall.utils.PageUtils;
import io.gulimall.entity.order.OrderReturnReasonEntity;
import java.util.Map;
public interface OrderReturnReasonService extends IService<OrderReturnReasonEntity>{


public PageUtils queryPage(Map<String,Object> params)
;

}