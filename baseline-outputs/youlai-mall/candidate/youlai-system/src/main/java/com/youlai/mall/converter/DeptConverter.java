package com.youlai.mall.converter;
 import com.youlai.mall.model.system.entity.SysDept;
import com.youlai.mall.model.system.form.DeptForm;
import com.youlai.mall.model.system.vo.DeptVO;
import org.mapstruct.Mapper;
@Mapper(componentModel = "spring")
public interface DeptConverter {


public DeptVO entity2Vo(SysDept entity)
;

public DeptForm entity2Form(SysDept entity)
;

public SysDept form2Entity(DeptForm deptForm)
;

}