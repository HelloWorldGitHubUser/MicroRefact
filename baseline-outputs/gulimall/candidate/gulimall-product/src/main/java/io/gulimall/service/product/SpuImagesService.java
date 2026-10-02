package io.gulimall.service.product;
 import com.baomidou.mybatisplus.extension.service.IService;
import io.gulimall.utils.PageUtils;
import io.gulimall.entity.product.SpuImagesEntity;
import java.util.List;
import java.util.Map;
public interface SpuImagesService extends IService<SpuImagesEntity>{


public PageUtils queryPage(Map<String,Object> params)
;

public void saveImages(Long id,List<String> images)
;

}