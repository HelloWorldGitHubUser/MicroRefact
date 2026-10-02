package com.youlai.mall.config.auth.oauth2.extension.wechat;
 import jakarta.annotation.Nullable;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.oauth2.core.endpoint.OAuth2ParameterNames;
import org.springframework.security.oauth2.server.authorization.authentication.OAuth2AuthorizationGrantAuthenticationToken;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
public class WechatAuthenticationToken extends OAuth2AuthorizationGrantAuthenticationToken{

 private  Set<String> scopes;

 public  AuthorizationGrantType WECHAT_MINI_APP;

protected WechatAuthenticationToken(Authentication clientPrincipal, Set<String> scopes, @Nullable Map<String, Object> additionalParameters) {
    super(WechatAuthenticationToken.WECHAT_MINI_APP, clientPrincipal, additionalParameters);
    this.scopes = Collections.unmodifiableSet(scopes != null ? new HashSet<>(scopes) : Collections.emptySet());
}
@Override
public Object getCredentials(){
    return this.getAdditionalParameters().get(OAuth2ParameterNames.CODE);
}


public Set<String> getScopes(){
    return scopes;
}


}