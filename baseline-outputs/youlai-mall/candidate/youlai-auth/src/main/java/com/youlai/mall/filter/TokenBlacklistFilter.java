package com.youlai.mall.filter;
 import cn.hutool.core.util.StrUtil;
import cn.hutool.jwt.JWTPayload;
import com.nimbusds.jose.JWSObject;
import com.youlai.mall.constant.RedisConstants;
import com.youlai.mall.result.ResultCode;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import java.io.IOException;
import java.text.ParseException;
@Slf4j
@Component
@RequiredArgsConstructor
public class TokenBlacklistFilter extends OncePerRequestFilter{

 private  RedisTemplate<String,Object> redisTemplate;

 private  String BEARER_PREFIX;


@Override
public void doFilterInternal(HttpServletRequest request,HttpServletResponse response,FilterChain filterChain) throws ServletException{
    String authorization = request.getHeader(HttpHeaders.AUTHORIZATION);
    if (StrUtil.isBlank(authorization) || !authorization.startsWith(BEARER_PREFIX)) {
        filterChain.doFilter(request, response);
        return;
    }
    try {
        String token = authorization.substring(BEARER_PREFIX.length());
        JWSObject jwsObject = JWSObject.parse(token);
        String jti = (String) jwsObject.getPayload().toJSONObject().get(JWTPayload.JWT_ID);
        // 检查黑名单
        Boolean isBlackToken = redisTemplate.hasKey(RedisConstants.TOKEN_BLACKLIST_PREFIX + jti);
        if (Boolean.TRUE.equals(isBlackToken)) {
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
            response.setContentType(MediaType.APPLICATION_JSON_VALUE);
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write("{\"code\":\"" + ResultCode.TOKEN_ACCESS_FORBIDDEN.getCode() + "\",\"msg\":\"" + ResultCode.TOKEN_ACCESS_FORBIDDEN.getMsg() + "\"}");
            return;
        }
    } catch (ParseException e) {
        log.error("解析Token失败", e);
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write("{\"code\":\"" + ResultCode.TOKEN_INVALID.getCode() + "\",\"msg\":\"" + ResultCode.TOKEN_INVALID.getMsg() + "\"}");
        return;
    }
    filterChain.doFilter(request, response);
}


}