package org.springframework.samples.petclinic;
 import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;
import org.springframework.samples.petclinic.Interface.ClinicService;
import org.springframework.samples.petclinic.Interface.ClinicServiceImpl;
import org.springframework.samples.petclinic.Interface.ClinicService;
import org.springframework.samples.petclinic.Interface.ClinicServiceImpl;
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
public ClinicService clinicservice(){

return  new ClinicServiceImpl(); 
    }



@Bean
public ClinicService clinicservice(){

return  new ClinicServiceImpl(); 
    }



}