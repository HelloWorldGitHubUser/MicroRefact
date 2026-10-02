package io.gulimall;
 import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;
import io.gulimall.Interface.MemberReceiveAddressService;
import io.gulimall.Interface.MemberReceiveAddressServiceImpl;
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
public MemberReceiveAddressService memberreceiveaddressservice(){

return  new MemberReceiveAddressServiceImpl(); 
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