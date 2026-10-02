package com.goodskill;
 import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;
import com.goodskill.Interface.SeckillMockController;
import com.goodskill.Interface.SeckillMockControllerImpl;
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
public SeckillMockController seckillmockcontroller(){

return  new SeckillMockControllerImpl(); 
    }



}