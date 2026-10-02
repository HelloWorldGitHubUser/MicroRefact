package io.gulimall.service.member;
 import com.baomidou.mybatisplus.extension.service.IService;
import io.gulimall.utils.PageUtils;
import io.gulimall.entity.member.MemberCollectSpuEntity;
import java.util.Map;
public interface MemberCollectSpuService extends IService<MemberCollectSpuEntity>{


public PageUtils queryPage(Map<String,Object> params)
;

}