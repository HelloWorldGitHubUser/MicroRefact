package com.central.service;
 import java.util.List;
import java.util.Map;
import com.central.model.PageResult;
import com.central.model.Result;
import com.central.entity.SysRole;
public interface ISysRoleService extends ISuperService<SysRole>{


public Result saveOrUpdateRole(SysRole sysRole) throws Exception
;

public void saveRole(SysRole sysRole) throws Exception
;

public void deleteRole(Long id)
;

public PageResult<SysRole> findRoles(Map<String,Object> params)
;

public List<SysRole> findAll()
;

}