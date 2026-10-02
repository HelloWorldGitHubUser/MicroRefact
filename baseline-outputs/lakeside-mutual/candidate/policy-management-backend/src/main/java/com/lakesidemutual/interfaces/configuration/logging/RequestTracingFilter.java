package com.lakesidemutual.interfaces.configuration.logging;
 import java.io.IOException;
import java.util.Random;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import org.slf4j.MDC;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
@Component
@Order(1)
public class RequestTracingFilter implements Filter{

 private  String REQUEST_ID_KEY;

 private  Random rand;


@Override
public void doFilter(ServletRequest request,ServletResponse response,FilterChain chain) throws IOException{
    MDC.put(REQUEST_ID_KEY, createRequestId());
    chain.doFilter(request, response);
}


public String createRequestId(){
    return Integer.toString(rand.nextInt(9999));
}


}