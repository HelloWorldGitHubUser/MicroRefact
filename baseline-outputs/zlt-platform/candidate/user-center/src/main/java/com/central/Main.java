package com.central;
 import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;
import com.central.Interface.LogicDelDto;
import com.central.Interface.LogicDelDtoImpl;
import com.central.Interface.ISearchService;
import com.central.Interface.ISearchServiceImpl;
import com.central.Interface.KeyedLock;
import com.central.Interface.KeyedLockImpl;
import com.central.Interface.KeyedLock;
import com.central.Interface.KeyedLockImpl;
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
public LogicDelDto logicdeldto(){

return  new LogicDelDtoImpl(); 
    }



@Bean
public ISearchService isearchservice(){

return  new ISearchServiceImpl(); 
    }



@Bean
public KeyedLock keyedlock(){

return  new KeyedLockImpl(); 
    }



@Bean
public KeyedLock keyedlock(){

return  new KeyedLockImpl(); 
    }



}