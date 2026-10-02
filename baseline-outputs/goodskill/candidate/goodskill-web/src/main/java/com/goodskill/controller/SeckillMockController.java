package com.goodskill.controller;
 import com.goodskill.dto.SeckillMockRequestDTO;
import com.goodskill.service.SeckillService;
import com.goodskill.enums.SeckillSolutionEnum;
import com.goodskill.exception.CommonException;
import com.goodskill.dto.Result;
import com.goodskill.dto.SeckillWebMockRequestDTO;
import com.goodskill.util.TaskTimeCaculateUtil;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;
import com.goodskill.enums.SeckillSolutionEnum;
import org.springframework.web.bind.annotation.RequestMethod.POST;
import com.goodskill.Interface.SeckillService;
@Tag(name = "模拟秒杀场景(无需登录)")
@RestController
@Slf4j
@Validated
public class SeckillMockController {

@Autowired
 private  SeckillService seckillService;

@Autowired
@Qualifier("webTaskExecutor")
 private  ThreadPoolTaskExecutor taskExecutor;

@Autowired
 private  StringRedisTemplate stringRedisTemplate;

 private  AtomicInteger SECKILL_PHONE_NUM_COUNTER;


@PostMapping("/task-info")
public Result<Long> getTaskId(Long seckillId){
    return Result.ok(Long.valueOf(stringRedisTemplate.opsForValue().get("SECKILL_TASK_ID_COUNTER")));
}


@GetMapping("/task-time-info")
public Result<String> getTaskTimeInfo(Long seckillId){
    String taskId = stringRedisTemplate.opsForValue().get("SECKILL_TASK_ID_COUNTER");
    if (!StringUtils.hasText(taskId)) {
        return Result.fail("暂无任务数据");
    }
    String taskTimeInfo = TaskTimeCaculateUtil.prettyPrint(taskId);
    if (taskTimeInfo == null) {
        return Result.fail("任务不存在或已过期");
    }
    return Result.ok(taskTimeInfo);
}


public void prepareSeckill(long seckillId,int seckillCount,String name,String taskId){
    seckillService.prepareSeckill(seckillId, seckillCount, taskId);
    TaskTimeCaculateUtil.startTask("秒杀活动id:" + seckillId + "," + name, taskId);
}


public void changeThreadPoolParam(SeckillWebMockRequestDTO dto){
    try {
        if (dto.getCorePoolSize() != null && dto.getCorePoolSize() > 0) {
            int corePoolSize = taskExecutor.getCorePoolSize();
            taskExecutor.setCorePoolSize(dto.getCorePoolSize());
            log.info("#changeThreadPoolParam 更新核心线程数参数生效, 原参数值:{},当前值:{}", corePoolSize, dto.getCorePoolSize());
        }
        if (dto.getMaxPoolSize() != null && dto.getMaxPoolSize() > 0) {
            int maxPoolSize = taskExecutor.getMaxPoolSize();
            taskExecutor.setMaxPoolSize(dto.getMaxPoolSize());
            log.info("#changeThreadPoolParam 更新最大线程数参数生效, 原参数值:{},当前值:{}", maxPoolSize, dto.getMaxPoolSize());
        }
    } catch (IllegalArgumentException e) {
        log.warn("#changeThreadPoolParam 核心线程数不能大于最大线程数，当前最大线程数:{}，当前核心线程数:{}", taskExecutor.getMaxPoolSize(), taskExecutor.getCorePoolSize(), e);
        throw new CommonException("线程池参数不合法，请重新设置！");
    }
}


public Long processSeckill(SeckillWebMockRequestDTO dto,SeckillSolutionEnum seckillSolutionEnum,Runnable runnable){
    log.debug("#processSeckill start count:{},当前线程池队列长度:{},线程数:{},是否空:{}", SECKILL_PHONE_NUM_COUNTER.get(), taskExecutor.getThreadPoolExecutor().getQueue().size(), taskExecutor.getPoolSize(), taskExecutor.getThreadPoolExecutor().getQueue().isEmpty());
    long seckillId = dto.getSeckillId();
    int seckillCount = dto.getSeckillCount();
    int requestCount = dto.getRequestCount();
    Long seckillTaskIdCounter = stringRedisTemplate.opsForValue().increment("SECKILL_TASK_ID_COUNTER");
    String taskId = String.valueOf(seckillTaskIdCounter);
    // 初始化库存数量
    prepareSeckill(seckillId, seckillCount, seckillSolutionEnum.getName(), taskId);
    changeThreadPoolParam(dto);
    log.info("{}开始时间:{}, 秒杀id:{}, 任务Id:{}", seckillSolutionEnum.getName(), new Date(), seckillId, taskId);
    if (runnable == null) {
        // 默认的执行方法
        runnable = () -> {
            String phoneNumber = String.valueOf(SECKILL_PHONE_NUM_COUNTER.incrementAndGet());
            seckillService.execute(new SeckillMockRequestDTO(seckillId, 1, phoneNumber, taskId), seckillSolutionEnum.getCode());
        };
    }
    for (int i = 0; i < requestCount; i++) {
        if (log.isDebugEnabled()) {
            log.debug("#processSeckill begin count:{},当前线程池队列长度:{},线程数:{},是否空:{}", SECKILL_PHONE_NUM_COUNTER.get(), taskExecutor.getThreadPoolExecutor().getQueue().size(), taskExecutor.getPoolSize(), taskExecutor.getThreadPoolExecutor().getQueue().isEmpty());
        }
        taskExecutor.execute(runnable);
    }
    return seckillTaskIdCounter;
}


@Operation(summary = "秒杀场景一(sychronized同步锁实现)")
@PostMapping("/sychronized")
public Result<Long> doWithSychronized(SeckillWebMockRequestDTO dto){
    Long l = processSeckill(dto, SYCHRONIZED);
    return Result.ok(l);
// 待mq监听器处理完成打印日志，不在此处打印日志
}


}