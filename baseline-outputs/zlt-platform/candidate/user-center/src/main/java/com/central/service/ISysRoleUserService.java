package com.central.service;
 import com.central.entity.SysRole;
import com.central.entity.SysRoleUser;
import java.util.List;
public interface ISysRoleUserService extends ISuperService<SysRoleUser>{


public int saveUserRoles(Long userId,Long roleId)
;

public int deleteUserRole(Long userId,Long roleId)
;

public List<SysRole> findRolesByUserIds(List<Long> userIds)
;

public List<SysRole> findRolesByUserId(Long userId)
;

}