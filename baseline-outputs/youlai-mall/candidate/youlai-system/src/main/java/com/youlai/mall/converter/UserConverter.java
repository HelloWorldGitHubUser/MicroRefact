package com.youlai.mall.converter;
 import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.youlai.mall.model.system.bo.UserBO;
import com.youlai.mall.model.system.bo.UserFormBO;
import com.youlai.mall.model.system.bo.UserProfileBO;
import com.youlai.mall.model.system.entity.SysUser;
import com.youlai.mall.model.system.form.UserForm;
import com.youlai.mall.model.system.vo.UserImportVO;
import com.youlai.mall.model.system.vo.UserInfoVO;
import com.youlai.mall.model.system.vo.UserPageVO;
import com.youlai.mall.model.system.vo.UserProfileVO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
@Mapper(componentModel = "spring")
public interface UserConverter {


public UserForm entity2Form(SysUser entity)
;

@Mappings({ @Mapping(target = "userId", source = "id") })
public UserInfoVO entity2UserInfoVo(SysUser entity)
;

public Page<UserPageVO> bo2Vo(Page<UserBO> bo)
;

public UserForm bo2Form(UserFormBO bo)
;

@Mappings({ @Mapping(target = "genderLabel", expression = "java(com.youlai.mall.base.IBaseEnum.getLabelByValue(bo.getGender(), com.youlai.mall.enums.GenderEnum.class))") })
public UserProfileVO userProfileBo2Vo(UserProfileBO bo)
;

public SysUser importVo2Entity(UserImportVO vo)
;

@InheritInverseConfiguration(name = "entity2Form")
public SysUser form2Entity(UserForm entity)
;

}