package io.gulimall.service.order;
 import com.baomidou.mybatisplus.extension.service.IService;
import io.gulimall.utils.PageUtils;
import io.gulimall.entity.order.PaymentInfoEntity;
import java.util.Map;
public interface PaymentInfoService extends IService<PaymentInfoEntity>{


public PageUtils queryPage(Map<String,Object> params)
;

}