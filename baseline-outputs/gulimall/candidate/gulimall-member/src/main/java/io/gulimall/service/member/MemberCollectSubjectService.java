package io.gulimall.service.member;
 import com.baomidou.mybatisplus.extension.service.IService;
import io.gulimall.utils.PageUtils;
import io.gulimall.entity.member.MemberCollectSubjectEntity;
import java.util.Map;
public interface MemberCollectSubjectService extends IService<MemberCollectSubjectEntity>{


public PageUtils queryPage(Map<String,Object> params)
;

}