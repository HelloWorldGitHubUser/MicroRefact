package io.gulimall.config;
 import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.templatemode.TemplateMode;
@Configuration
public class ThymeleafConfig {


@Bean
@Primary
public SpringResourceTemplateResolver templateResolver(){
    SpringResourceTemplateResolver resolver = new SpringResourceTemplateResolver();
    // 设置基础路径为 classpath 根目录
    resolver.setPrefix("classpath:/");
    resolver.setSuffix(".html");
    resolver.setTemplateMode(TemplateMode.HTML);
    resolver.setCharacterEncoding("UTF-8");
    // 开发环境关闭缓存
    resolver.setCacheable(false);
    resolver.setOrder(1);
    return resolver;
}


}