package com.lakesidemutual.interfaces.configuration;
 import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;
@Component
public class UnauthorizedHandler implements AuthenticationEntryPoint{


@Override
public void commence(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse,AuthenticationException e) throws IOException{
    httpServletResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Access Denied");
}


}