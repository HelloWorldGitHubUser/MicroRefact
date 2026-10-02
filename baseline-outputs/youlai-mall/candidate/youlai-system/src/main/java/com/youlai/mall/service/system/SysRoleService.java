package com.youlai.mall.service.system;
 import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.youlai.mall.model.system.entity.SysRole;
import com.youlai.mall.model.system.form.RoleForm;
import com.youlai.mall.model.system.query.RolePageQuery;
import com.youlai.mall.web.model.Option;
import com.youlai.mall.model.system.vo.RolePageVO;
import java.util.List;
import java.util.Set;
public interface SysRoleService extends IService<SysRole>{


public RoleForm getRoleForm(Long roleId)
;

public boolean updateRoleStatus(Long roleId,Integer status)
;

public boolean assignMenusToRole(Long roleId,List<Long> menuIds)
;

public List<Long> getRoleMenuIds(Long roleId)
;

public Integer getMaxDataRangeDataScope(Set<String> roles)
;

public boolean saveRole(RoleForm roleForm)
;

public boolean deleteRoles(String ids)
;

public List<Option> listRoleOptions()
;

public Page<RolePageVO> getRolePage(RolePageQuery queryParams)
;

}