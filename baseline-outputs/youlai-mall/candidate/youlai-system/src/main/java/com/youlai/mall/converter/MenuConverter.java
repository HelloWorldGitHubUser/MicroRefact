package com.youlai.mall.converter;
 import com.youlai.mall.model.system.entity.SysMenu;
import com.youlai.mall.model.system.form.MenuForm;
import com.youlai.mall.model.system.vo.MenuVO;
import org.mapstruct.Mapper;
@Mapper(componentModel = "spring")
public interface MenuConverter {


public MenuVO entity2Vo(SysMenu entity)
;

public MenuForm entity2Form(SysMenu entity)
;

public SysMenu form2Entity(MenuForm menuForm)
;

}