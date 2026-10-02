package io.gulimall.service.member;
 import com.baomidou.mybatisplus.extension.service.IService;
import io.gulimall.utils.PageUtils;
import io.gulimall.entity.member.IntegrationChangeHistoryEntity;
import java.util.Map;
public interface IntegrationChangeHistoryService extends IService<IntegrationChangeHistoryEntity>{


public PageUtils queryPage(Map<String,Object> params)
;

}