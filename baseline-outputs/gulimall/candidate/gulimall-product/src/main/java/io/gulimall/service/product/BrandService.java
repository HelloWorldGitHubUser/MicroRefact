package io.gulimall.service.product;
 import com.baomidou.mybatisplus.extension.service.IService;
import io.gulimall.utils.PageUtils;
import io.gulimall.entity.product.BrandEntity;
import java.util.Map;
public interface BrandService extends IService<BrandEntity>{


public PageUtils queryPage(Map<String,Object> params)
;

public void updateCascade(BrandEntity brand)
;

}