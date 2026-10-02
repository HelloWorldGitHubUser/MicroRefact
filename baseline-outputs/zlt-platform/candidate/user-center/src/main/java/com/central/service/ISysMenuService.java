package com.central.service;
 import java.util.List;
import java.util.Set;
import com.central.entity.SysMenu;
public interface ISysMenuService extends ISuperService<SysMenu>{


public List<SysMenu> findOnes()
;

public List<SysMenu> findByRoles(Set<Long> roleIds,Integer type)
;

public List<SysMenu> findByUserId(Long userId,Integer type)
;

public void setMenuToRole(Long roleId,Set<Long> menuIds)
;

public List<SysMenu> findAll()
;

public List<SysMenu> findByRoleCodes(Set<String> roleCodes,Integer type)
;

}