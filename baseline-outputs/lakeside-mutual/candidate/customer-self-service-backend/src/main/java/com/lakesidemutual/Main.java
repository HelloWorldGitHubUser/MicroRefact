package com.lakesidemutual;
 import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;
import com.lakesidemutual.Interface.PolicyQuoteService;
import com.lakesidemutual.Interface.PolicyQuoteServiceImpl;
import com.lakesidemutual.Interface.CustomerId;
import com.lakesidemutual.Interface.CustomerIdImpl;
import com.lakesidemutual.Interface.CityLookupService;
import com.lakesidemutual.Interface.CityLookupServiceImpl;
import com.lakesidemutual.Interface.CustomerService;
import com.lakesidemutual.Interface.CustomerServiceImpl;
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
public PolicyQuoteService policyquoteservice(){

return  new PolicyQuoteServiceImpl(); 
    }



@Bean
public CustomerId customerid(){

return  new CustomerIdImpl(); 
    }



@Bean
public CityLookupService citylookupservice(){

return  new CityLookupServiceImpl(); 
    }



@Bean
public CustomerService customerservice(){

return  new CustomerServiceImpl(); 
    }



}