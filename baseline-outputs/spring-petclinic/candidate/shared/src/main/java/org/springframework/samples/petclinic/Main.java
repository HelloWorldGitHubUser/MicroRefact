package org.springframework.samples.petclinic;
 import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;
import org.springframework.samples.petclinic.Interface.PetRepository;
import org.springframework.samples.petclinic.Interface.PetRepositoryImpl;
import org.springframework.samples.petclinic.Interface.VetRepository;
import org.springframework.samples.petclinic.Interface.VetRepositoryImpl;
import org.springframework.samples.petclinic.Interface.OwnerRepository;
import org.springframework.samples.petclinic.Interface.OwnerRepositoryImpl;
import org.springframework.samples.petclinic.Interface.VisitRepository;
import org.springframework.samples.petclinic.Interface.VisitRepositoryImpl;
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
public PetRepository petrepository(){

return  new PetRepositoryImpl(); 
    }



@Bean
public VetRepository vetrepository(){

return  new VetRepositoryImpl(); 
    }



@Bean
public OwnerRepository ownerrepository(){

return  new OwnerRepositoryImpl(); 
    }



@Bean
public VisitRepository visitrepository(){

return  new VisitRepositoryImpl(); 
    }



}