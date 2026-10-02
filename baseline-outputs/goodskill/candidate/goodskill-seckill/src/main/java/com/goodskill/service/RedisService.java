package com.goodskill.service;
 import com.goodskill.entity.mysql.Seckill;
import com.goodskill.mapper.SeckillMapper;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import java.util.concurrent.TimeUnit;
@Component
@Slf4j
public class RedisService {

@Autowired
 private  SeckillMapper seckillMapper;

@Resource
 private  RedisTemplate<String,Object> redisTemplate;

@Resource
 private  StringRedisTemplate stringRedisTemplate;


public Seckill getSeckill(long seckillId){
    String key = "seckill:" + seckillId;
    Seckill seckill = (Seckill) redisTemplate.opsForValue().get(key);
    if (seckill != null) {
        return seckill;
    } else {
        seckill = seckillMapper.selectById(seckillId);
        if (seckill == null) {
            throw new RuntimeException("秒杀活动不存在！");
        }
        putSeckill(seckill);
        return seckill;
    }
}


public Boolean clearSeckillEndFlag(long seckillId,String taskId){
    return stringRedisTemplate.delete("goodskill:seckill:end:notice" + seckillId + ":" + taskId);
}


public void putSeckill(Seckill seckill){
    String key = "seckill:" + seckill.getSeckillId();
    int timeout = 60;
    redisTemplate.opsForValue().set(key, seckill, timeout, TimeUnit.SECONDS);
}


public void removeSeckill(long seckillId){
    String key = "seckill:" + seckillId;
    redisTemplate.delete(key);
    redisTemplate.delete(String.valueOf(seckillId));
}


public Boolean setSeckillEndFlag(long seckillId,String taskId){
    return stringRedisTemplate.opsForValue().setIfAbsent("goodskill:seckill:end:notice" + seckillId + ":" + taskId, "1");
}


}