package com.hoangtien2k3.ecommerce;
 import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;
import com.hoangtien2k3.ecommerce.Interface.OrderResponse;
import com.hoangtien2k3.ecommerce.Interface.OrderResponseImpl;
import com.hoangtien2k3.ecommerce.Interface.UserResponse;
import com.hoangtien2k3.ecommerce.Interface.UserResponseImpl;
import com.hoangtien2k3.ecommerce.Interface.PaymentEventDto;
import com.hoangtien2k3.ecommerce.Interface.PaymentEventDtoImpl;
import com.hoangtien2k3.ecommerce.Interface.OrderService;
import com.hoangtien2k3.ecommerce.Interface.OrderServiceImpl;
import com.hoangtien2k3.ecommerce.Interface.UserService;
import com.hoangtien2k3.ecommerce.Interface.UserServiceImpl;
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
public OrderResponse orderresponse(){

return  new OrderResponseImpl(); 
    }



@Bean
public UserResponse userresponse(){

return  new UserResponseImpl(); 
    }



@Bean
public PaymentEventDto paymenteventdto(){

return  new PaymentEventDtoImpl(); 
    }



@Bean
public OrderService orderservice(){

return  new OrderServiceImpl(); 
    }



@Bean
public UserService userservice(){

return  new UserServiceImpl(); 
    }



}