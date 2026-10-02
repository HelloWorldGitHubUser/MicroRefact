package io.gulimall.service.member;
 import com.baomidou.mybatisplus.extension.service.IService;
import io.gulimall.utils.PageUtils;
import io.gulimall.entity.member.MemberLoginLogEntity;
import java.util.Map;
public interface MemberLoginLogService extends IService<MemberLoginLogEntity>{


public PageUtils queryPage(Map<String,Object> params)
;

}