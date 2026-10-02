package com.youlai.mall.service.system;
 import com.baomidou.mybatisplus.extension.service.IService;
import com.youlai.mall.model.system.entity.SysUserRole;
import java.util.List;
public interface SysUserRoleService extends IService<SysUserRole>{


public boolean saveUserRoles(Long userId,List<Long> roleIds)
;

public boolean hasAssignedUsers(Long roleId)
;

}