package io.gulimall.service.member;
 import com.baomidou.mybatisplus.extension.service.IService;
import io.gulimall.utils.PageUtils;
import io.gulimall.entity.member.MemberLevelEntity;
import java.util.Map;
public interface MemberLevelService extends IService<MemberLevelEntity>{


public PageUtils queryPage(Map<String,Object> params)
;

}