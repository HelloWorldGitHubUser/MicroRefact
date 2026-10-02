package io.gulimall.service.ware;
 import com.baomidou.mybatisplus.extension.service.IService;
import io.gulimall.utils.PageUtils;
import io.gulimall.entity.ware.PurchaseDetailEntity;
import java.util.Map;
public interface PurchaseDetailService extends IService<PurchaseDetailEntity>{


public PageUtils queryPage(Map<String,Object> params)
;

}