package com.youlai.mall.config.auth;
 import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
@Configuration
@ConfigurationProperties(prefix = "captcha")
@Data
public class CaptchaProperties {

 private  String type;

 private  int width;

 private  int height;

 private  int interfereCount;

 private  Float textAlpha;

 private  Long expireSeconds;

 private  CodeProperties code;

 private  FontProperties font;

 private  String type;

 private  int length;

 private  String name;

 private  int weight;

 private  int size;


}