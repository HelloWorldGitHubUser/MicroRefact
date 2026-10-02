package ltd.newbee.mall.api;
 import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;
import ltd.newbee.mall.api.Interface.NewBeeMallGoodsMapper;
import ltd.newbee.mall.api.Interface.NewBeeMallGoodsMapperImpl;
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
public NewBeeMallGoodsMapper newbeemallgoodsmapper(){

return  new NewBeeMallGoodsMapperImpl(); 
    }



}