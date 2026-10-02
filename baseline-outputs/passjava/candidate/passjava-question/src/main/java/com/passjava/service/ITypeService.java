package com.passjava.service;
 import com.baomidou.mybatisplus.extension.service.IService;
import com.passjava.utils.PageUtils;
import com.passjava.entity.TypeEntity;
import java.util.List;
import java.util.Map;
public interface ITypeService extends IService<TypeEntity>{


public List<TypeEntity> getTypeEntityList()
;

public PageUtils queryPage(Map<String,Object> params)
;

public List<TypeEntity> getTypeEntityListWithLock()
;

}