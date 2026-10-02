package com.passjava;
 import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication
@MapperScan("com.passjava.dao")
public class PassJavaApplication {


public void main(String[] args){
    SpringApplication.run(PassJavaApplication.class, args);
}


}