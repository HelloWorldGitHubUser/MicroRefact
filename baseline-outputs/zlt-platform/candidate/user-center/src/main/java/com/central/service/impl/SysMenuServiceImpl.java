package com.central.service.impl;
 import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.central.entity.SysMenu;
import com.central.entity.SysRoleMenu;
import com.central.service.ISysRoleMenuService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import com.central.mapper.SysMenuMapper;
import com.central.service.ISysMenuService;
import lombok.extern.slf4j.Slf4j;
import jakarta.annotation.Resource;
@Slf4j
@Service
public class SysMenuServiceImpl extends SuperServiceImpl<SysMenuMapper, SysMenu>implements ISysMenuService{

@Resource
 private  ISysRoleMenuService roleMenuService;


@Override
public List<SysMenu> findByRoles(Set<Long> roleIds,Integer type){
    return roleMenuService.findMenusByRoleIds(roleIds, type);
}


@Override
public List<SysMenu> findOnes(){
    return baseMapper.selectList(new QueryWrapper<SysMenu>().eq("type", 1).orderByAsc("sort"));
}


@Override
public List<SysMenu> findByUserId(Long userId,Integer type){
    return baseMapper.findByUserId(userId, type);
}


@Transactional(rollbackFor = Exception.class)
@Override
public void setMenuToRole(Long roleId,Set<Long> menuIds){
    roleMenuService.delete(roleId, null);
    if (!CollectionUtils.isEmpty(menuIds)) {
        List<SysRoleMenu> roleMenus = new ArrayList<>(menuIds.size());
        menuIds.forEach(menuId -> roleMenus.add(new SysRoleMenu(roleId, menuId)));
        roleMenuService.saveBatch(roleMenus);
    }
}


@Override
public List<SysMenu> findAll(){
    return baseMapper.selectList(new QueryWrapper<SysMenu>().orderByAsc("sort"));
}


@Override
public List<SysMenu> findByRoleCodes(Set<String> roleCodes,Integer type){
    return roleMenuService.findMenusByRoleCodes(roleCodes, type);
}


}