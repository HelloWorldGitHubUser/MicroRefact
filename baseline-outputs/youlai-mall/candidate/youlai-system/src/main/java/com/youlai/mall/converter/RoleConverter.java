package com.youlai.mall.converter;
 import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.youlai.mall.web.model.Option;
import com.youlai.mall.model.system.entity.SysRole;
import com.youlai.mall.model.system.form.RoleForm;
import com.youlai.mall.model.system.vo.RolePageVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import java.util.List;
@Mapper(componentModel = "spring")
public interface RoleConverter {


public List<Option> entities2Options(List<SysRole> roles)
;

public Page<RolePageVO> entity2Page(Page<SysRole> page)
;

public RoleForm entity2Form(SysRole entity)
;

@Mappings({ @Mapping(target = "value", source = "id"), @Mapping(target = "label", source = "name") })
public Option entity2Option(SysRole role)
;

public SysRole form2Entity(RoleForm roleForm)
;

}