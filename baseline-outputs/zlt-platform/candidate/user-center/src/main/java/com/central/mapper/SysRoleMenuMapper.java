package com.central.mapper;
 import java.util.List;
import java.util.Set;
import com.central.entity.SysRoleMenu;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.central.entity.SysMenu;
@Mapper
public interface SysRoleMenuMapper extends SuperMapper<SysRoleMenu>{


public List<SysMenu> findMenusByRoleCodes(Set<String> roleCodes,Integer type)
;

@Insert("insert into sys_role_menu(role_id, menu_id) values(#{roleId}, #{menuId})")
public int save(Long roleId,Long menuId)
;

public List<SysMenu> findMenusByRoleIds(Set<Long> roleIds,Integer type)
;

public int delete(Long roleId,Long menuId)
;

}