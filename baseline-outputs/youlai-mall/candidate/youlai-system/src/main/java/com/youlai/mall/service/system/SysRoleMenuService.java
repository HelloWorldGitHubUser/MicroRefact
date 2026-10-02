package com.youlai.mall.service.system;
 import com.baomidou.mybatisplus.extension.service.IService;
import com.youlai.mall.model.system.entity.SysRoleMenu;
import java.util.List;
public interface SysRoleMenuService extends IService<SysRoleMenu>{


public void refreshRolePermsCache(String oldRoleCode,String newRoleCode)
;

public List<Long> listMenuIdsByRoleId(Long roleId)
;

}