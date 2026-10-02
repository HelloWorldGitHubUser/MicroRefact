package io.gulimall.service.ware;
 import com.baomidou.mybatisplus.extension.service.IService;
import io.gulimall.utils.PageUtils;
import io.gulimall.entity.ware.WareOrderTaskEntity;
import java.util.Map;
public interface WareOrderTaskService extends IService<WareOrderTaskEntity>{


public PageUtils queryPage(Map<String,Object> params)
;

}