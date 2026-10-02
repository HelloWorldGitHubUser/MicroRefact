package io.gulimall;
 import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;
import io.gulimall.Interface.MemberService;
import io.gulimall.Interface.MemberServiceImpl;
import io.gulimall.Interface.MemberService;
import io.gulimall.Interface.MemberServiceImpl;
import io.gulimall.Interface.SmsComponent;
import io.gulimall.Interface.SmsComponentImpl;
import io.gulimall.Interface.MemberService;
import io.gulimall.Interface.MemberServiceImpl;
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
public MemberService memberservice(){

return  new MemberServiceImpl(); 
    }



@Bean
public MemberService memberservice(){

return  new MemberServiceImpl(); 
    }



@Bean
public SmsComponent smscomponent(){

return  new SmsComponentImpl(); 
    }



@Bean
public MemberService memberservice(){

return  new MemberServiceImpl(); 
    }



}