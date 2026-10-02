package com.passjava.service;
 import com.baomidou.mybatisplus.extension.service.IService;
import com.passjava.utils.PageUtils;
import com.passjava.entity.ViewLogEntity;
import java.util.Map;
public interface ViewLogService extends IService<ViewLogEntity>{


public PageUtils queryPage(Map<String,Object> params)
;

}