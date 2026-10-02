package io.gulimall.service.product;
 import com.baomidou.mybatisplus.extension.service.IService;
import io.gulimall.utils.PageUtils;
import io.gulimall.entity.product.SkuImagesEntity;
import java.util.Map;
public interface SkuImagesService extends IService<SkuImagesEntity>{


public PageUtils queryPage(Map<String,Object> params)
;

}