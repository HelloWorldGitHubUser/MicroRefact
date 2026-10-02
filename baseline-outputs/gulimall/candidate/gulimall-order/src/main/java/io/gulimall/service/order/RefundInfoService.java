package io.gulimall.service.order;
 import com.baomidou.mybatisplus.extension.service.IService;
import io.gulimall.utils.PageUtils;
import io.gulimall.entity.order.RefundInfoEntity;
import java.util.Map;
public interface RefundInfoService extends IService<RefundInfoEntity>{


public PageUtils queryPage(Map<String,Object> params)
;

}