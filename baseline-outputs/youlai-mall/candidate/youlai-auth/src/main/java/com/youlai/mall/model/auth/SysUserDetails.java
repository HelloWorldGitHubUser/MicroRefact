package com.youlai.mall.model.auth;
 import cn.hutool.core.collection.CollectionUtil;
import com.youlai.mall.enums.StatusEnum;
import com.youlai.mall.model.system.dto.UserAuthInfo;
import lombok.Data;
import org.springframework.security.core.CredentialsContainer;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.Assert;
import java.util.Collection;
import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;
@Data
public class SysUserDetails implements UserDetails,CredentialsContainer{

 private  Long userId;

 private  Long deptId;

 private  Integer dataScope;

 private  String username;

 private  String password;

 private  Boolean enabled;

 private  Collection<GrantedAuthority> authorities;

 private  boolean accountNonExpired;

 private  boolean accountNonLocked;

 private  boolean credentialsNonExpired;

 private  Set<String> perms;

/**
 * 系统管理用户
 */
public SysUserDetails(UserAuthInfo user) {
    this.setUserId(user.getUserId());
    this.setUsername(user.getUsername());
    this.setDeptId(user.getDeptId());
    this.setDataScope(user.getDataScope());
    this.setPassword(user.getPassword());
    this.setEnabled(StatusEnum.ENABLE.getValue().equals(user.getStatus()));
    if (CollectionUtil.isNotEmpty(user.getRoles())) {
        authorities = user.getRoles().stream().map(SimpleGrantedAuthority::new).collect(Collectors.toSet());
    }
    this.setPerms(user.getPerms());
}public SysUserDetails(Long userId, String username, String password, Integer dataScope, Long deptId, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked, Set<? extends GrantedAuthority> authorities) {
    Assert.isTrue(username != null && !"".equals(username) && password != null, "Cannot pass null or empty values to constructor");
    this.userId = userId;
    this.username = username;
    this.password = password;
    this.dataScope = dataScope;
    this.deptId = deptId;
    this.enabled = enabled;
    this.accountNonExpired = accountNonExpired;
    this.credentialsNonExpired = credentialsNonExpired;
    this.accountNonLocked = accountNonLocked;
    this.authorities = Collections.unmodifiableSet(authorities);
}
@Override
public String getPassword(){
    return this.password;
}


@Override
public boolean isAccountNonExpired(){
    return true;
}


@Override
public boolean isCredentialsNonExpired(){
    return true;
}


@Override
public void eraseCredentials(){
    this.password = null;
}


@Override
public boolean isEnabled(){
    return this.enabled;
}


@Override
public boolean isAccountNonLocked(){
    return true;
}


@Override
public Collection<? extends GrantedAuthority> getAuthorities(){
    return this.authorities;
}


@Override
public String getUsername(){
    return this.username;
}


}