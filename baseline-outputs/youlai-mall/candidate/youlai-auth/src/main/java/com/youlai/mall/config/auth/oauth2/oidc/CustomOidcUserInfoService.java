package com.youlai.mall.config.auth.oauth2.oidc;
 import com.youlai.mall.service.system.SysUserService;
import com.youlai.mall.model.system.dto.UserAuthInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.Optional;
import com.youlai.mall.Interface.SysUserService;
@Service
@Slf4j
public class CustomOidcUserInfoService {

 private  SysUserService sysUserService;

public CustomOidcUserInfoService(SysUserService sysUserService) {
    this.sysUserService = sysUserService;
}
public CustomOidcUserInfo loadUserByUsername(String username){
    UserAuthInfo userAuthInfo = null;
    try {
        userAuthInfo = sysUserService.getUserAuthInfo(username);
        if (userAuthInfo == null) {
            return null;
        }
        return new CustomOidcUserInfo(createUser(userAuthInfo));
    } catch (Exception e) {
        log.error("获取用户信息失败", e);
        return null;
    }
}


public Map<String,Object> createUser(UserAuthInfo userAuthInfo){
    return CustomOidcUserInfo.customBuilder().username(userAuthInfo.getUsername()).nickname(userAuthInfo.getNickname()).status(userAuthInfo.getStatus()).phoneNumber(userAuthInfo.getMobile()).email(userAuthInfo.getEmail()).profile(userAuthInfo.getAvatar()).build().getClaims();
}


}