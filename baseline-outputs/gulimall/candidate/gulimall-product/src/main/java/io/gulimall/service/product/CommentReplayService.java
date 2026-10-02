package io.gulimall.service.product;
 import com.baomidou.mybatisplus.extension.service.IService;
import io.gulimall.utils.PageUtils;
import io.gulimall.entity.product.CommentReplayEntity;
import java.util.Map;
public interface CommentReplayService extends IService<CommentReplayEntity>{


public PageUtils queryPage(Map<String,Object> params)
;

}