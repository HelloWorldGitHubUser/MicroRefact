package com.hoangtien2k3.ecommerce;
 import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;
import com.hoangtien2k3.ecommerce.Interface.ProductResponse;
import com.hoangtien2k3.ecommerce.Interface.ProductResponseImpl;
import com.hoangtien2k3.ecommerce.Interface.UserService;
import com.hoangtien2k3.ecommerce.Interface.UserServiceImpl;
import com.hoangtien2k3.ecommerce.Interface.ProductService;
import com.hoangtien2k3.ecommerce.Interface.ProductServiceImpl;
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
public ProductResponse productresponse(){

return  new ProductResponseImpl(); 
    }



@Bean
public UserService userservice(){

return  new UserServiceImpl(); 
    }



@Bean
public ProductService productservice(){

return  new ProductServiceImpl(); 
    }



}