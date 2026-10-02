package com.youlai.mall;
 import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;
import com.youlai.mall.Interface.PermissionService;
import com.youlai.mall.Interface.PermissionServiceImpl;
import com.youlai.mall.Interface.SmsService;
import com.youlai.mall.Interface.SmsServiceImpl;
import com.youlai.mall.Interface.AliyunSmsProperties;
import com.youlai.mall.Interface.AliyunSmsPropertiesImpl;
@SpringBootApplication
public class Main {


@Bean
public RestTemplate restTemplate(){
 
 return new RestTemplate();

  }



public static void main(String[] args){

SpringApplication.run(Main.class,args);

   }



@Bean
public PermissionService permissionservice(){

return  new PermissionServiceImpl(); 
    }



@Bean
public SmsService smsservice(){

return  new SmsServiceImpl(); 
    }



@Bean
public AliyunSmsProperties aliyunsmsproperties(){

return  new AliyunSmsPropertiesImpl(); 
    }



}