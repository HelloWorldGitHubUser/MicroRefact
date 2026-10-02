package io.gulimall.service.ware;
 import com.baomidou.mybatisplus.extension.service.IService;
import io.gulimall.utils.PageUtils;
import io.gulimall.entity.ware.WareOrderTaskDetailEntity;
import java.util.Map;
public interface WareOrderTaskDetailService extends IService<WareOrderTaskDetailEntity>{


public PageUtils queryPage(Map<String,Object> params)
;

}