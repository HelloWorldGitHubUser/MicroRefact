package io.gulimall.service.coupon;
 import com.baomidou.mybatisplus.extension.service.IService;
import io.gulimall.utils.PageUtils;
import io.gulimall.entity.coupon.HomeSubjectEntity;
import java.util.Map;
public interface HomeSubjectService extends IService<HomeSubjectEntity>{


public PageUtils queryPage(Map<String,Object> params)
;

}