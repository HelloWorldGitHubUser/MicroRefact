package com.passjava.service;
 import com.baomidou.mybatisplus.extension.service.IService;
import com.passjava.utils.PageUtils;
import com.passjava.entity.AccessTokenEntity;
import java.util.Map;
public interface AccessTokenService extends IService<AccessTokenEntity>{


public PageUtils queryPage(Map<String,Object> params)
;

}