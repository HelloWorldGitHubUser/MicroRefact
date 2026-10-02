package com.youlai.mall.model.auth;
 import com.youlai.mall.constant.GlobalConstants;
import com.youlai.mall.model.ums.dto.MemberAuthDTO;
import java.util.HashSet;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.Collection;
import java.util.Collections;
@Data
public class MemberDetails implements UserDetails{

 private  Long id;

 private  String username;

 private  Boolean enabled;

 private  String authenticationIdentity;

/**
 * 会员信息构造
 *
 * @param memAuthInfo 会员认证信息
 */
public MemberDetails(MemberAuthDTO memAuthInfo) {
    this.setId(memAuthInfo.getId());
    this.setUsername(memAuthInfo.getUsername());
    this.setEnabled(GlobalConstants.STATUS_YES.equals(memAuthInfo.getStatus()));
}
@Override
public String getPassword(){
    return null;
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
public boolean isEnabled(){
    return this.enabled;
}


@Override
public boolean isAccountNonLocked(){
    return true;
}


@Override
public Collection<? extends GrantedAuthority> getAuthorities(){
    return new HashSet<>();
}


@Override
public String getUsername(){
    return this.username;
}


}