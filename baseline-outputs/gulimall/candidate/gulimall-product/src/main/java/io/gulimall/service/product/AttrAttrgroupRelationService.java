package io.gulimall.service.product;
 import com.baomidou.mybatisplus.extension.service.IService;
import io.gulimall.utils.PageUtils;
import io.gulimall.entity.product.AttrAttrgroupRelationEntity;
import java.util.Map;
public interface AttrAttrgroupRelationService extends IService<AttrAttrgroupRelationEntity>{


public PageUtils queryPage(Map<String,Object> params)
;

}