package io.gulimall.service.product;
 import com.baomidou.mybatisplus.extension.service.IService;
import io.gulimall.utils.PageUtils;
import io.gulimall.entity.product.SpuInfoDescEntity;
import java.util.Map;
public interface SpuInfoDescService extends IService<SpuInfoDescEntity>{


public void saveSpuInfoDesc(SpuInfoDescEntity descEntity)
;

public PageUtils queryPage(Map<String,Object> params)
;

}