package com.youlai.mall.config.auth.oauth2.extension.captcha;
 import jakarta.annotation.Nullable;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.oauth2.core.endpoint.OAuth2ParameterNames;
import org.springframework.security.oauth2.server.authorization.authentication.OAuth2AuthorizationGrantAuthenticationToken;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
public class CaptchaAuthenticationToken extends OAuth2AuthorizationGrantAuthenticationToken{

 private  Set<String> scopes;

 public  AuthorizationGrantType CAPTCHA;

/**
 * 验证码模式身份验证令牌
 *
 * @param clientPrincipal      客户端信息
 * @param scopes               令牌申请访问范围
 * @param additionalParameters 自定义额外参数(用户名、密码、验证码)
 */
public CaptchaAuthenticationToken(Authentication clientPrincipal, Set<String> scopes, @Nullable Map<String, Object> additionalParameters) {
    super(CAPTCHA, clientPrincipal, additionalParameters);
    this.scopes = Collections.unmodifiableSet(scopes != null ? new HashSet<>(scopes) : Collections.emptySet());
}
@Override
public Object getCredentials(){
    return this.getAdditionalParameters().get(OAuth2ParameterNames.PASSWORD);
}


public Set<String> getScopes(){
    return scopes;
}


}