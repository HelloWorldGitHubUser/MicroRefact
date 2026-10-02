package com.youlai.mall.config.auth.oauth2.handler;
 import com.youlai.mall.result.Result;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.core.convert.converter.Converter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.server.ServletServerHttpResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.OAuth2AccessToken;
import org.springframework.security.oauth2.core.OAuth2RefreshToken;
import org.springframework.security.oauth2.core.endpoint.DefaultOAuth2AccessTokenResponseMapConverter;
import org.springframework.security.oauth2.core.endpoint.OAuth2AccessTokenResponse;
import org.springframework.security.oauth2.server.authorization.authentication.OAuth2AccessTokenAuthenticationToken;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.util.CollectionUtils;
import java.io.IOException;
import java.time.temporal.ChronoUnit;
import java.util.Map;
public class MyAuthenticationSuccessHandler implements AuthenticationSuccessHandler{

 private  HttpMessageConverter<Object> accessTokenHttpResponseConverter;

 private  Converter<OAuth2AccessTokenResponse,Map<String,Object>> accessTokenResponseParametersConverter;


@Override
public void onAuthenticationSuccess(HttpServletRequest request,HttpServletResponse response,Authentication authentication) throws IOException{
    OAuth2AccessTokenAuthenticationToken accessTokenAuthentication = (OAuth2AccessTokenAuthenticationToken) authentication;
    OAuth2AccessToken accessToken = accessTokenAuthentication.getAccessToken();
    OAuth2RefreshToken refreshToken = accessTokenAuthentication.getRefreshToken();
    Map<String, Object> additionalParameters = accessTokenAuthentication.getAdditionalParameters();
    OAuth2AccessTokenResponse.Builder builder = OAuth2AccessTokenResponse.withToken(accessToken.getTokenValue()).tokenType(accessToken.getTokenType());
    if (accessToken.getIssuedAt() != null && accessToken.getExpiresAt() != null) {
        builder.expiresIn(ChronoUnit.SECONDS.between(accessToken.getIssuedAt(), accessToken.getExpiresAt()));
    }
    if (refreshToken != null) {
        builder.refreshToken(refreshToken.getTokenValue());
    }
    if (!CollectionUtils.isEmpty(additionalParameters)) {
        builder.additionalParameters(additionalParameters);
    }
    OAuth2AccessTokenResponse accessTokenResponse = builder.build();
    Map<String, Object> tokenResponseParameters = this.accessTokenResponseParametersConverter.convert(accessTokenResponse);
    ServletServerHttpResponse httpResponse = new ServletServerHttpResponse(response);
    String clientId = accessTokenAuthentication.getRegisteredClient().getClientId();
    if ("client".equals(clientId)) {
        // Knife4j测试客户端ID（Knife4j自动填充的 access_token 须原生返回，不能被包装成业务码数据格式）
        this.accessTokenHttpResponseConverter.write(tokenResponseParameters, null, httpResponse);
    } else {
        this.accessTokenHttpResponseConverter.write(Result.success(tokenResponseParameters), null, httpResponse);
    }
}


}