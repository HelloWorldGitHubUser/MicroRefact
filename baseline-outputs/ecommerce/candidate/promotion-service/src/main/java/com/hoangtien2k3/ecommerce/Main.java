package com.hoangtien2k3.ecommerce;
 import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;
import com.hoangtien2k3.ecommerce.Interface.ProductService;
import com.hoangtien2k3.ecommerce.Interface.ProductServiceImpl;
import com.hoangtien2k3.ecommerce.Interface.CategoryService;
import com.hoangtien2k3.ecommerce.Interface.CategoryServiceImpl;
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
public ProductService productservice(){

return  new ProductServiceImpl(); 
    }



@Bean
public CategoryService categoryservice(){

return  new CategoryServiceImpl(); 
    }



}