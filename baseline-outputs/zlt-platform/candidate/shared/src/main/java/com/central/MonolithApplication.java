package com.central;
 import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
@EnableAsync
@SpringBootApplication
public class MonolithApplication {


public void main(String[] args){
    SpringApplication.run(MonolithApplication.class, args);
}


}