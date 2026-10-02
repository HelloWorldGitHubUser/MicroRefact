package com.passjava;
 import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;
import com.passjava.conInterface.StudyTimeService;
import com.passjava.conInterface.StudyTimeServiceImpl;
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
public StudyTimeService studytimeservice(){

return  new StudyTimeServiceImpl(); 
    }



}