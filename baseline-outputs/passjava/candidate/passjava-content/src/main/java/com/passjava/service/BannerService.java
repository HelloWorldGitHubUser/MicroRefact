package com.passjava.service;
 import com.baomidou.mybatisplus.extension.service.IService;
import com.passjava.utils.PageUtils;
import com.passjava.entity.BannerEntity;
import java.util.Map;
public interface BannerService extends IService<BannerEntity>{


public PageUtils queryPage(Map<String,Object> params)
;

}