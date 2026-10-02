package com.youlai.mall.apidoc.ApiDocInfoProperties;
 import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
@Data
public class Contact {

 private  String name;

 private  String url;

 private  String email;


}