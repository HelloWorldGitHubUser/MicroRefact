package com.goodskill;
 import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;
@SpringBootApplication(scanBasePackages = "com.goodskill", exclude = { com.alibaba.cloud.ai.autoconfigure.dashscope.DashScopeAutoConfiguration.class, com.alibaba.cloud.ai.autoconfigure.prompt.PromptTemplateAutoConfiguration.class })
@EnableTransactionManagement
@MapperScan("com.goodskill.mapper")
@EnableAsync
@Slf4j
public class GoodskillMonoApplication {


public void main(String[] args){
    SpringApplication application = new SpringApplication(GoodskillMonoApplication.class);
    application.setBannerMode(Banner.Mode.CONSOLE);
    application.run(args);
    log.info("====================================");
    log.info("GoodsKill单体应用启动成功！");
    log.info("====================================");
}


}