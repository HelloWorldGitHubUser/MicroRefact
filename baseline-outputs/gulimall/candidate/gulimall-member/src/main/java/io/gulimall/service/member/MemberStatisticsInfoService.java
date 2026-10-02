package io.gulimall.service.member;
 import com.baomidou.mybatisplus.extension.service.IService;
import io.gulimall.utils.PageUtils;
import io.gulimall.entity.member.MemberStatisticsInfoEntity;
import java.util.Map;
public interface MemberStatisticsInfoService extends IService<MemberStatisticsInfoEntity>{


public PageUtils queryPage(Map<String,Object> params)
;

}