package com.youlai.mall.converter;
 import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.youlai.mall.model.system.entity.SysDict;
import com.youlai.mall.model.system.form.DictForm;
import com.youlai.mall.model.system.vo.DictPageVO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
@Mapper(componentModel = "spring")
public interface DictConverter {


public Page<DictPageVO> entity2Page(Page<SysDict> page)
;

public DictForm entity2Form(SysDict entity)
;

@InheritInverseConfiguration(name = "entity2Form")
public SysDict form2Entity(DictForm entity)
;

}