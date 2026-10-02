package com.youlai.mall.mapper;
 import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.youlai.mall.model.system.bo.RolePermsBO;
import com.youlai.mall.model.system.entity.SysRoleMenu;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;
@Mapper
public interface SysRoleMenuMapper extends BaseMapper<SysRoleMenu>{


public List<Long> listMenuIdsByRoleId(Long roleId)
;

public List<RolePermsBO> getRolePermsList(String roleCode)
;

}