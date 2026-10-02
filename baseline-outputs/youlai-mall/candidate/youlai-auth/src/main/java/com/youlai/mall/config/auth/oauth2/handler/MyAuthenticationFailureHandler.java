package com.youlai.mall.config.auth.oauth2.handler;
 import com.youlai.mall.result.Result;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.server.ServletServerHttpResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.OAuth2Error;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import java.io.IOException;
import com.youlai.mall.DTO.Result;
@Slf4j
public class MyAuthenticationFailureHandler implements AuthenticationFailureHandler{

 private  HttpMessageConverter<Object> accessTokenHttpResponseConverter;


@Override
public void onAuthenticationFailure(HttpServletRequest request,HttpServletResponse response,AuthenticationException exception) throws IOException{
    OAuth2Error error = ((OAuth2AuthenticationException) exception).getError();
    ServletServerHttpResponse httpResponse = new ServletServerHttpResponse(response);
    Result result = Result.failed(error.getErrorCode());
    accessTokenHttpResponseConverter.write(result, null, httpResponse);
}


}