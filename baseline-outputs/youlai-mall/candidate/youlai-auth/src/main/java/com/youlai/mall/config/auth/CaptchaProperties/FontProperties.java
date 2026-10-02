package com.youlai.mall.config.auth.CaptchaProperties;
 import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
@Data
public class FontProperties {

 private  String name;

 private  int weight;

 private  int size;


}