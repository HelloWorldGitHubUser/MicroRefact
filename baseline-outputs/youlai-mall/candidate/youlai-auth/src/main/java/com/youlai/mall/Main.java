package com.youlai.mall;
 import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;
import com.youlai.mall.Interface.SysUserService;
import com.youlai.mall.Interface.SysUserServiceImpl;
import com.youlai.mall.Interface.AliyunSmsProperties;
import com.youlai.mall.Interface.AliyunSmsPropertiesImpl;
import com.youlai.mall.Interface.SmsService;
import com.youlai.mall.Interface.SmsServiceImpl;
import com.youlai.mall.Interface.UmsMemberService;
import com.youlai.mall.Interface.UmsMemberServiceImpl;
import com.youlai.mall.Interface.SysUserService;
import com.youlai.mall.Interface.SysUserServiceImpl;
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
public SysUserService sysuserservice(){

return  new SysUserServiceImpl(); 
    }



@Bean
public AliyunSmsProperties aliyunsmsproperties(){

return  new AliyunSmsPropertiesImpl(); 
    }



@Bean
public SmsService smsservice(){

return  new SmsServiceImpl(); 
    }



@Bean
public UmsMemberService umsmemberservice(){

return  new UmsMemberServiceImpl(); 
    }



@Bean
public SysUserService sysuserservice(){

return  new SysUserServiceImpl(); 
    }



}