package io.gulimall.service.member;
 import com.baomidou.mybatisplus.extension.service.IService;
import io.gulimall.utils.PageUtils;
import io.gulimall.entity.member.GrowthChangeHistoryEntity;
import java.util.Map;
public interface GrowthChangeHistoryService extends IService<GrowthChangeHistoryEntity>{


public PageUtils queryPage(Map<String,Object> params)
;

}