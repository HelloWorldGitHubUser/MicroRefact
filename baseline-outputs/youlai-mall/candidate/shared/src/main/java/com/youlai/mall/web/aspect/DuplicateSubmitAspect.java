package com.youlai.mall.web.aspect;
 import cn.hutool.core.util.StrUtil;
import com.youlai.mall.result.ResultCode;
import com.youlai.mall.security.util.SecurityUtils;
import com.youlai.mall.web.annotation.PreventDuplicateResubmit;
import com.youlai.mall.web.exception.BizException;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import java.util.concurrent.ConcurrentHashMap;
@Aspect
@Component
@Slf4j
public class DuplicateSubmitAspect {

 private  ConcurrentHashMap<String,Long> submitRecordMap;

 private  String RESUBMIT_LOCK_PREFIX;


@Around("preventDuplicateSubmitPointCut(preventDuplicateResubmit)")
public Object doAround(ProceedingJoinPoint pjp,PreventDuplicateResubmit preventDuplicateResubmit) throws Throwable{
    HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
    String jti = SecurityUtils.getJti();
    if (StrUtil.isNotBlank(jti)) {
        String resubmitLockKey = RESUBMIT_LOCK_PREFIX + jti + ":" + request.getMethod() + "-" + request.getRequestURI();
        // 防重提交锁过期时间（秒）
        int expire = preventDuplicateResubmit.expire();
        long now = System.currentTimeMillis();
        long expireTime = now + expire * 1000L;
        // 使用compute()保证原子性
        Long existingExpireTime = submitRecordMap.compute(resubmitLockKey, (k, oldTime) -> {
            if (oldTime != null && oldTime > now) {
                // 时间窗口内，保持旧值
                return oldTime;
            }
            // 记录新的提交时间
            return expireTime;
        });
        // 判断是否重复提交
        if (existingExpireTime != null && !existingExpireTime.equals(expireTime)) {
            // 抛出重复提交提示信息
            throw new BizException(ResultCode.REPEAT_SUBMIT_ERROR);
        }
    }
    return pjp.proceed();
}


@Scheduled(fixedRate = 60000)
public void cleanExpiredRecords(){
    long now = System.currentTimeMillis();
    submitRecordMap.entrySet().removeIf(entry -> entry.getValue() < now);
}


@Pointcut("@annotation(preventDuplicateResubmit)")
public void preventDuplicateSubmitPointCut(PreventDuplicateResubmit preventDuplicateResubmit){
    log.info("定义防重复提交切点");
}


}