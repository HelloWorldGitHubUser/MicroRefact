package com.youlai.mall.config.auth;
 import cn.hutool.core.collection.CollectionUtil;
import com.youlai.mall.filter.TokenBlacklistFilter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.servlet.util.matcher.MvcRequestMatcher;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.servlet.handler.HandlerMappingIntrospector;
import java.util.List;
@ConfigurationProperties(prefix = "security")
@Configuration(proxyBeanMethods = false)
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

 private  TokenBlacklistFilter tokenBlacklistFilter;

 private  AccessDeniedHandler accessDeniedHandler;

 private  AuthenticationEntryPoint authenticationEntryPoint;

@Setter
 private  List<String> whitelistPaths;


@Bean
@Order(0)
public SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http,HandlerMappingIntrospector introspector) throws Exception{
    MvcRequestMatcher.Builder mvcMatcherBuilder = new MvcRequestMatcher.Builder(introspector);
    http.authorizeHttpRequests((requests) -> {
        if (CollectionUtil.isNotEmpty(whitelistPaths)) {
            for (String whitelistPath : whitelistPaths) {
                requests.requestMatchers(mvcMatcherBuilder.pattern(whitelistPath)).permitAll();
            }
        }
        requests.anyRequest().authenticated();
    }).csrf(AbstractHttpConfigurer::disable).formLogin(Customizer.withDefaults()).oauth2ResourceServer(oauth2ResourceServer -> oauth2ResourceServer.jwt(Customizer.withDefaults())).addFilterBefore(tokenBlacklistFilter, UsernamePasswordAuthenticationFilter.class).exceptionHandling(exceptionHandling -> exceptionHandling.authenticationEntryPoint(authenticationEntryPoint).accessDeniedHandler(accessDeniedHandler));
    return http.build();
}


@Bean
public WebSecurityCustomizer webSecurityCustomizer(){
    return (web) -> web.ignoring().requestMatchers(AntPathRequestMatcher.antMatcher("/webjars/**"), AntPathRequestMatcher.antMatcher("/doc.html"), AntPathRequestMatcher.antMatcher("/swagger-resources/**"), AntPathRequestMatcher.antMatcher("/v3/api-docs/**"), AntPathRequestMatcher.antMatcher("/swagger-ui/**"));
}


}