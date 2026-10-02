package com.central;
 import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;
import com.central.Interface.ISysUserService;
import com.central.Interface.ISysUserServiceImpl;
import com.central.Interface.ISysUserService;
import com.central.Interface.ISysUserServiceImpl;
import com.central.Interface.ISysUserService;
import com.central.Interface.ISysUserServiceImpl;
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
public ISysUserService isysuserservice(){

return  new ISysUserServiceImpl(); 
    }



@Bean
public ISysUserService isysuserservice(){

return  new ISysUserServiceImpl(); 
    }



@Bean
public ISysUserService isysuserservice(){

return  new ISysUserServiceImpl(); 
    }



}