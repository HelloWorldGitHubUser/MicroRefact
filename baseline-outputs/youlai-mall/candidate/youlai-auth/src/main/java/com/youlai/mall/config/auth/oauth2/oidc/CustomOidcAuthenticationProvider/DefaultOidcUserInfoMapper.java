package com.youlai.mall.config.auth.oauth2.oidc.CustomOidcAuthenticationProvider;
 import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.oauth2.core.OAuth2AccessToken;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.oidc.OidcIdToken;
import org.springframework.security.oauth2.server.authorization.OAuth2Authorization;
import org.springframework.security.oauth2.server.authorization.OAuth2AuthorizationService;
import org.springframework.security.oauth2.server.authorization.OAuth2TokenType;
import org.springframework.security.oauth2.server.authorization.oidc.authentication.OidcUserInfoAuthenticationContext;
import org.springframework.security.oauth2.server.authorization.oidc.authentication.OidcUserInfoAuthenticationToken;
import org.springframework.security.oauth2.server.resource.authentication.AbstractOAuth2TokenAuthenticationToken;
import org.springframework.util.Assert;
import java.util;
import java.util.function.Function;
public class DefaultOidcUserInfoMapper implements Function<OidcUserInfoAuthenticationContext, CustomOidcUserInfo>{

 private  List<String> EMAIL_CLAIMS;

 private  List<String> PHONE_CLAIMS;

 private  List<String> PROFILE_CLAIMS;

private DefaultOidcUserInfoMapper() {
}
@Override
public CustomOidcUserInfo apply(OidcUserInfoAuthenticationContext authenticationContext){
    OAuth2Authorization authorization = authenticationContext.getAuthorization();
    OidcIdToken idToken = authorization.getToken(OidcIdToken.class).getToken();
    OAuth2AccessToken accessToken = authenticationContext.getAccessToken();
    Map<String, Object> scopeRequestedClaims = getClaimsRequestedByScope(idToken.getClaims(), accessToken.getScopes());
    return new CustomOidcUserInfo(scopeRequestedClaims);
}


public Map<String,Object> getClaimsRequestedByScope(Map<String,Object> claims,Set<String> requestedScopes){
    Set<String> scopeRequestedClaimNames = new HashSet<>(32);
    scopeRequestedClaimNames.add("sub");
    if (requestedScopes.contains("address")) {
        scopeRequestedClaimNames.add("address");
    }
    if (requestedScopes.contains("email")) {
        scopeRequestedClaimNames.addAll(EMAIL_CLAIMS);
    }
    if (requestedScopes.contains("phone")) {
        scopeRequestedClaimNames.addAll(PHONE_CLAIMS);
    }
    if (requestedScopes.contains("profile")) {
        scopeRequestedClaimNames.addAll(PROFILE_CLAIMS);
    }
    Map<String, Object> requestedClaims = new HashMap<>(claims);
    requestedClaims.keySet().removeIf((claimName) -> !scopeRequestedClaimNames.contains(claimName));
    return requestedClaims;
}


}