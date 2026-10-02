package io.gulimall;
 import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;
import io.gulimall.Interface.SeckillSessionService;
import io.gulimall.Interface.SeckillSessionServiceImpl;
import io.gulimall.Interface.SkuInfoService;
import io.gulimall.Interface.SkuInfoServiceImpl;
import io.gulimall.Interface.OrderService;
import io.gulimall.Interface.OrderServiceImpl;
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
public SeckillSessionService seckillsessionservice(){

return  new SeckillSessionServiceImpl(); 
    }



@Bean
public SkuInfoService skuinfoservice(){

return  new SkuInfoServiceImpl(); 
    }



@Bean
public OrderService orderservice(){

return  new OrderServiceImpl(); 
    }



}