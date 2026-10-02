package com.lakesidemutual.interfaces.configuration;
 import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import es.moki.ratelimitj.core.limiter.request.RequestLimitRule;
import es.moki.ratelimitj.core.limiter.request.RequestRateLimiter;
import es.moki.ratelimitj.inmemory.request.InMemorySlidingWindowRequestRateLimiter;
@Component
public class RateLimitInterceptor implements HandlerInterceptor{

 private  Logger logger;

 private  RequestRateLimiter requestRateLimiter;

 private  int requestsPerMinute;

@Autowired
public RateLimitInterceptor(@Value("${rate.limit.perMinute}") int requestsPerMinute) {
    this.requestsPerMinute = requestsPerMinute;
    Set<RequestLimitRule> rules = Collections.singleton(RequestLimitRule.of(Duration.of(1, ChronoUnit.MINUTES), requestsPerMinute));
    requestRateLimiter = new InMemorySlidingWindowRequestRateLimiter(rules);
}
@Override
public boolean preHandle(HttpServletRequest request,HttpServletResponse response,Object object) throws Exception{
    String clientRemoteAddr = request.getRemoteAddr();
    boolean overLimit = requestRateLimiter.overLimitWhenIncremented(clientRemoteAddr);
    if (overLimit) {
        logger.info("Client " + clientRemoteAddr + " has been rate limited.");
        response.setStatus(HttpStatus.TOO_MANY_REQUESTS.value());
    }
    response.addHeader("X-RateLimit-Limit", String.valueOf(requestsPerMinute));
    return !overLimit;
}


}