package io.gulimall.service.coupon;
 import com.baomidou.mybatisplus.extension.service.IService;
import io.gulimall.utils.PageUtils;
import io.gulimall.entity.coupon.SkuLadderEntity;
import java.util.Map;
public interface SkuLadderService extends IService<SkuLadderEntity>{


public PageUtils queryPage(Map<String,Object> params)
;

}