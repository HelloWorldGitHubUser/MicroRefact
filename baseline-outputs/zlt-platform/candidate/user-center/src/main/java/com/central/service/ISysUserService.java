package com.central.service;
 import java.util.List;
import java.util.Map;
import java.util.Set;
import com.central.model.SysUserExcel;
import com.central.model.PageResult;
import com.central.model.Result;
import com.central.entity.SysRole;
import com.central.entity.SysUser;
public interface ISysUserService extends ISuperService<SysUser>{


public SysUser selectByMobile(String mobile)
;

public Result updatePassword(Long id,String oldPassword,String newPassword)
;

public SysUser selectByOpenId(String openId)
;

public void setRoleToUser(Long id,Set<Long> roleIds)
;

public List<SysRole> findRolesByUserId(Long userId)
;

public void setUserPermission(SysUser sysUser)
;

public SysUser selectByUsername(String username)
;

public SysUser findByOpenId(String openId)
;

public SysUser findByUsername(String username)
;

public boolean delUser(Long id)
;

public PageResult<SysUser> findUsers(Map<String,Object> params)
;

public Result saveOrUpdateUser(SysUser sysUser) throws Exception
;

public List<SysUserExcel> findAllUsers(Map<String,Object> params)
;

public SysUser findByMobile(String mobile)
;

public Result updateEnabled(Map<String,Object> params)
;

}