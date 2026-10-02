package com.central;
 import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;
import com.central.Interface.ISearchService;
import com.central.Interface.ISearchServiceImpl;
import com.central.Interface.IAggregationService;
import com.central.Interface.IAggregationServiceImpl;
import com.central.Interface.ISearchService;
import com.central.Interface.ISearchServiceImpl;
import com.central.Interface.ISearchService;
import com.central.Interface.ISearchServiceImpl;
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
public ISearchService isearchservice(){

return  new ISearchServiceImpl(); 
    }



@Bean
public IAggregationService iaggregationservice(){

return  new IAggregationServiceImpl(); 
    }



@Bean
public ISearchService isearchservice(){

return  new ISearchServiceImpl(); 
    }



@Bean
public ISearchService isearchservice(){

return  new ISearchServiceImpl(); 
    }



}