package ltd.newbee.mall.api;
 import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;
import ltd.newbee.mall.api.Interface.NewBeeAdminUserTokenMapper;
import ltd.newbee.mall.api.Interface.NewBeeAdminUserTokenMapperImpl;
import ltd.newbee.mall.api.Interface.MallUserMapper;
import ltd.newbee.mall.api.Interface.MallUserMapperImpl;
import ltd.newbee.mall.api.Interface.NewBeeMallUserTokenMapper;
import ltd.newbee.mall.api.Interface.NewBeeMallUserTokenMapperImpl;
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
public NewBeeAdminUserTokenMapper newbeeadminusertokenmapper(){

return  new NewBeeAdminUserTokenMapperImpl(); 
    }



@Bean
public MallUserMapper mallusermapper(){

return  new MallUserMapperImpl(); 
    }



@Bean
public NewBeeMallUserTokenMapper newbeemallusertokenmapper(){

return  new NewBeeMallUserTokenMapperImpl(); 
    }



}