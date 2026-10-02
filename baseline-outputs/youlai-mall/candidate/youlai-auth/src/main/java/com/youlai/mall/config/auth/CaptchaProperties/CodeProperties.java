package com.youlai.mall.config.auth.CaptchaProperties;
 import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
@Data
public class CodeProperties {

 private  String type;

 private  int length;


}