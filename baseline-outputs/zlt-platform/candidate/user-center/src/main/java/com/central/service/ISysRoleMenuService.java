package com.central.service;
 import com.central.entity.SysMenu;
import com.central.entity.SysRoleMenu;
import java.util.List;
import java.util.Set;
public interface ISysRoleMenuService extends ISuperService<SysRoleMenu>{


public List<SysMenu> findMenusByRoleCodes(Set<String> roleCodes,Integer type)
;

public int save(Long roleId,Long menuId)
;

public List<SysMenu> findMenusByRoleIds(Set<Long> roleIds,Integer type)
;

public int delete(Long roleId,Long menuId)
;

}