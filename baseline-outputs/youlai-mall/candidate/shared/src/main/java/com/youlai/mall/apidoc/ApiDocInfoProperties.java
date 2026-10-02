package com.youlai.mall.apidoc;
 import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
@Data
@ConfigurationProperties(prefix = "springdoc.info")
public class ApiDocInfoProperties {

 private  String title;

 private  String version;

 private  String description;

 private  Contact contact;

 private  License license;

 private  String name;

 private  String url;

 private  String email;

 private  String name;

 private  String url;


}