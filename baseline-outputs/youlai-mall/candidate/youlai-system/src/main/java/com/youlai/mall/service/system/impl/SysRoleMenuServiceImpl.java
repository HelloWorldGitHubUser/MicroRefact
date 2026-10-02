package com.youlai.mall.service.system.impl;
 import cn.hutool.core.collection.CollectionUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.youlai.mall.constant.RedisConstants;
import com.youlai.mall.mapper.SysRoleMenuMapper;
import com.youlai.mall.model.system.bo.RolePermsBO;
import com.youlai.mall.model.system.entity.SysRoleMenu;
import com.youlai.mall.service.system.SysRoleMenuService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Set;
@Service
@RequiredArgsConstructor
public class SysRoleMenuServiceImpl extends ServiceImpl<SysRoleMenuMapper, SysRoleMenu>implements SysRoleMenuService{

 private  RedisTemplate<String,Object> redisTemplate;


@PostConstruct
public void initRolePermsCache(){
    refreshRolePermsCache();
}


@Override
public void refreshRolePermsCache(String oldRoleCode,String newRoleCode){
    // 清理旧角色权限缓存
    redisTemplate.opsForHash().delete(RedisConstants.ROLE_PERMS_PREFIX, oldRoleCode);
    // 添加新角色权限缓存
    List<RolePermsBO> list = this.baseMapper.getRolePermsList(newRoleCode);
    if (CollectionUtil.isNotEmpty(list)) {
        RolePermsBO rolePerms = list.get(0);
        if (rolePerms == null) {
            return;
        }
        Set<String> perms = rolePerms.getPerms();
        redisTemplate.opsForHash().put(RedisConstants.ROLE_PERMS_PREFIX, newRoleCode, perms);
    }
}


@Override
public List<Long> listMenuIdsByRoleId(Long roleId){
    return this.baseMapper.listMenuIdsByRoleId(roleId);
}


}