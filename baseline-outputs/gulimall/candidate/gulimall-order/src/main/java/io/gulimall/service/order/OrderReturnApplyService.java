package io.gulimall.service.order;
 import com.baomidou.mybatisplus.extension.service.IService;
import io.gulimall.utils.PageUtils;
import io.gulimall.entity.order.OrderReturnApplyEntity;
import java.util.Map;
public interface OrderReturnApplyService extends IService<OrderReturnApplyEntity>{


public PageUtils queryPage(Map<String,Object> params)
;

}