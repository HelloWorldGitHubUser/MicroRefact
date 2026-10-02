package io.gulimall;
 import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;
import io.gulimall.Interface.CartService;
import io.gulimall.Interface.CartServiceImpl;
import io.gulimall.Interface.SeckillService;
import io.gulimall.Interface.SeckillServiceImpl;
import io.gulimall.Interface.SkuFullReductionService;
import io.gulimall.Interface.SkuFullReductionServiceImpl;
import io.gulimall.Interface.SpuBoundsService;
import io.gulimall.Interface.SpuBoundsServiceImpl;
import io.gulimall.Interface.WareSkuService;
import io.gulimall.Interface.WareSkuServiceImpl;
import io.gulimall.Interface.ProductSaveService;
import io.gulimall.Interface.ProductSaveServiceImpl;
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
public CartService cartservice(){

return  new CartServiceImpl(); 
    }



@Bean
public SeckillService seckillservice(){

return  new SeckillServiceImpl(); 
    }



@Bean
public SkuFullReductionService skufullreductionservice(){

return  new SkuFullReductionServiceImpl(); 
    }



@Bean
public SpuBoundsService spuboundsservice(){

return  new SpuBoundsServiceImpl(); 
    }



@Bean
public WareSkuService wareskuservice(){

return  new WareSkuServiceImpl(); 
    }



@Bean
public ProductSaveService productsaveservice(){

return  new ProductSaveServiceImpl(); 
    }



}