package com.youlai.mall.converter;
 import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.youlai.mall.model.system.entity.SysDictType;
import com.youlai.mall.model.system.form.DictTypeForm;
import com.youlai.mall.model.system.vo.DictTypePageVO;
import org.mapstruct.Mapper;
@Mapper(componentModel = "spring")
public interface DictTypeConverter {


public Page<DictTypePageVO> entity2Page(Page<SysDictType> page)
;

public DictTypeForm entity2Form(SysDictType entity)
;

public SysDictType form2Entity(DictTypeForm entity)
;

}