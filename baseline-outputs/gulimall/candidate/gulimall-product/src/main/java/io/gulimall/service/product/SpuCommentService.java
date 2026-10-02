package io.gulimall.service.product;
 import com.baomidou.mybatisplus.extension.service.IService;
import io.gulimall.utils.PageUtils;
import io.gulimall.entity.product.SpuCommentEntity;
import java.util.Map;
public interface SpuCommentService extends IService<SpuCommentEntity>{


public PageUtils queryPage(Map<String,Object> params)
;

}