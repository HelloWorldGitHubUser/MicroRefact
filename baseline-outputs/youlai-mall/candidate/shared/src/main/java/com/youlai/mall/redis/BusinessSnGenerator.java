package com.youlai.mall.redis;
 import cn.hutool.core.util.StrUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
@Component
@Slf4j
@RequiredArgsConstructor
public class BusinessSnGenerator {

 private  RedisTemplate redisTemplate;


public String generateSerialNo(String businessType){
    return this.generateSerialNo(businessType, 6);
}


}