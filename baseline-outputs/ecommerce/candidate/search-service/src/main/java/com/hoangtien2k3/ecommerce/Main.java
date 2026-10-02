package com.hoangtien2k3.ecommerce;
 import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;
import com.hoangtien2k3.ecommerce.Interface.ProductRepository;
import com.hoangtien2k3.ecommerce.Interface.ProductRepositoryImpl;
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
public ProductRepository productrepository(){

return  new ProductRepositoryImpl(); 
    }



}