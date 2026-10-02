package com.youlai.mall.service.auth;
 import cn.hutool.core.lang.Assert;
import com.youlai.mall.model.auth.LoginUserInfo;
import com.youlai.mall.model.auth.SysUserDetails;
import com.youlai.mall.enums.StatusEnum;
import com.youlai.mall.service.system.SysUserService;
import com.youlai.mall.model.system.dto.UserAuthInfo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import com.youlai.mall.Interface.SysUserService;
@Service("sysUserDetailsService")
@RequiredArgsConstructor
@Slf4j
public class SysUserDetailsService implements UserDetailsService{

 private  SysUserService sysUserService;


public LoginUserInfo getLoginUserInfo(){
    LoginUserInfo loginUserInfo = new LoginUserInfo();
    loginUserInfo.setId(123L);
    return loginUserInfo;
}


@Override
public UserDetails loadUserByUsername(String username){
    log.info("=== 开始加载用户信息: {} ===", username);
    UserAuthInfo userAuthInfo = sysUserService.getUserAuthInfo(username);
    log.info("从数据库查询到的用户信息: {}", userAuthInfo);
    Assert.isTrue(userAuthInfo != null, "用户不存在");
    if (userAuthInfo.getPassword() != null) {
        log.info("数据库中的密码哈希: {}", userAuthInfo.getPassword());
    } else {
        log.error("警告: 数据库中密码为空!");
    }
    if (!StatusEnum.ENABLE.getValue().equals(userAuthInfo.getStatus())) {
        throw new DisabledException("该账户已被禁用!");
    }
    log.info("创建 SysUserDetails 对象");
    return new SysUserDetails(userAuthInfo);
}


}