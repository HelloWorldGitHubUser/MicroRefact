package io.gulimall.service.coupon;
 import com.baomidou.mybatisplus.extension.service.IService;
import io.gulimall.utils.PageUtils;
import io.gulimall.entity.coupon.HomeSubjectSpuEntity;
import java.util.Map;
public interface HomeSubjectSpuService extends IService<HomeSubjectSpuEntity>{


public PageUtils queryPage(Map<String,Object> params)
;

}