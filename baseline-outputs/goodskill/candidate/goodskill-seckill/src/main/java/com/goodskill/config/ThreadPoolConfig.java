package com.goodskill.config;
 import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
@Configuration
public class ThreadPoolConfig {


@Bean("taskExecutor")
public ThreadPoolExecutor taskExecutor(){
    return new ThreadPoolExecutor(2, 10, 1, TimeUnit.MINUTES, new LinkedBlockingDeque<>(100), new ThreadPoolExecutor.CallerRunsPolicy());
}


@Bean("webTaskExecutor")
public ThreadPoolTaskExecutor webTaskExecutor(){
    ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
    executor.setCorePoolSize(2);
    executor.setMaxPoolSize(10);
    executor.setQueueCapacity(100);
    executor.setKeepAliveSeconds(60);
    executor.setThreadNamePrefix("web-task-");
    executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
    executor.initialize();
    return executor;
}


}