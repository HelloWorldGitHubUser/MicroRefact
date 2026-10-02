package com.hoangtien2k3.ecommerce;
 import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
@SpringBootApplication
@EnableAsync
public class EcommerceApplication {


public void main(String[] args){
    SpringApplication.run(EcommerceApplication.class, args);
}


}