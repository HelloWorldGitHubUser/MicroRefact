package com.youlai.mall;
 import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;
import com.youlai.mall.Interface.SkuService;
import com.youlai.mall.Interface.SkuServiceImpl;
import com.youlai.mall.Interface.SkuService;
import com.youlai.mall.Interface.SkuServiceImpl;
import com.youlai.mall.Interface.UmsMemberService;
import com.youlai.mall.Interface.UmsMemberServiceImpl;
import com.youlai.mall.Interface.SkuService;
import com.youlai.mall.Interface.SkuServiceImpl;
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
public SkuService skuservice(){

return  new SkuServiceImpl(); 
    }



@Bean
public SkuService skuservice(){

return  new SkuServiceImpl(); 
    }



@Bean
public UmsMemberService umsmemberservice(){

return  new UmsMemberServiceImpl(); 
    }



@Bean
public SkuService skuservice(){

return  new SkuServiceImpl(); 
    }



}