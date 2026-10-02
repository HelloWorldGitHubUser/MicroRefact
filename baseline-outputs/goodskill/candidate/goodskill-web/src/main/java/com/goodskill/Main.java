package com.goodskill;
 import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;
import com.goodskill.Interface.SeckillService;
import com.goodskill.Interface.SeckillServiceImpl;
import com.goodskill.Interface.SeckillService;
import com.goodskill.Interface.SeckillServiceImpl;
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
public SeckillService seckillservice(){

return  new SeckillServiceImpl(); 
    }



@Bean
public SeckillService seckillservice(){

return  new SeckillServiceImpl(); 
    }



}