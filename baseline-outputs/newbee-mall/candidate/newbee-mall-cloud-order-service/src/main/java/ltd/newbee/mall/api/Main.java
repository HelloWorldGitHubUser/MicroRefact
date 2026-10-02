package ltd.newbee.mall.api;
 import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;
import ltd.newbee.mall.api.Interface.NewBeeMallShoppingCartService;
import ltd.newbee.mall.api.Interface.NewBeeMallShoppingCartServiceImpl;
import ltd.newbee.mall.api.Interface.NewBeeMallShoppingCartItemMapper;
import ltd.newbee.mall.api.Interface.NewBeeMallShoppingCartItemMapperImpl;
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
public NewBeeMallShoppingCartService newbeemallshoppingcartservice(){

return  new NewBeeMallShoppingCartServiceImpl(); 
    }



@Bean
public NewBeeMallShoppingCartItemMapper newbeemallshoppingcartitemmapper(){

return  new NewBeeMallShoppingCartItemMapperImpl(); 
    }



@Bean
public NewBeeMallGoodsMapper newbeemallgoodsmapper(){

return  new NewBeeMallGoodsMapperImpl(); 
    }



}