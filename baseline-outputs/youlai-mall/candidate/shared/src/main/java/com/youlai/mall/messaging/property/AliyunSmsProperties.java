package com.youlai.mall.messaging.property;
 import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import java.util.Map;
@Configuration
@ConfigurationProperties(prefix = "sms.aliyun")
@Data
public class AliyunSmsProperties {

 private  String accessKeyId;

 private  String accessKeySecret;

 private  String domain;

 private  String regionId;

 private  String signName;

 private  Map<String,String> templateCodes;


}