package com.passjava.service;
 import com.baomidou.mybatisplus.extension.service.IService;
import com.passjava.utils.PageUtils;
import com.passjava.entity.GrowthChangeHistoryEntity;
import java.util.Map;
public interface GrowthChangeHistoryService extends IService<GrowthChangeHistoryEntity>{


public PageUtils queryPage(Map<String,Object> params)
;

}