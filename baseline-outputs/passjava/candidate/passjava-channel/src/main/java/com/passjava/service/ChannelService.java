package com.passjava.service;
 import com.baomidou.mybatisplus.extension.service.IService;
import com.passjava.utils.PageUtils;
import com.passjava.entity.ChannelEntity;
import java.util.Map;
public interface ChannelService extends IService<ChannelEntity>{


public PageUtils queryPage(Map<String,Object> params)
;

}