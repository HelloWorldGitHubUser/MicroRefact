package io.gulimall;
 import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;
import io.gulimall.Interface.CartService;
import io.gulimall.Interface.CartServiceImpl;
import io.gulimall.Interface.MemberReceiveAddressService;
import io.gulimall.Interface.MemberReceiveAddressServiceImpl;
import io.gulimall.Interface.WareSkuService;
import io.gulimall.Interface.WareSkuServiceImpl;
import io.gulimall.Interface.WareInfoService;
import io.gulimall.Interface.WareInfoServiceImpl;
import io.gulimall.Interface.SkuInfoService;
import io.gulimall.Interface.SkuInfoServiceImpl;
import io.gulimall.Interface.SpuInfoService;
import io.gulimall.Interface.SpuInfoServiceImpl;
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
public MemberReceiveAddressService memberreceiveaddressservice(){

return  new MemberReceiveAddressServiceImpl(); 
    }



@Bean
public WareSkuService wareskuservice(){

return  new WareSkuServiceImpl(); 
    }



@Bean
public WareInfoService wareinfoservice(){

return  new WareInfoServiceImpl(); 
    }



@Bean
public SkuInfoService skuinfoservice(){

return  new SkuInfoServiceImpl(); 
    }



@Bean
public SpuInfoService spuinfoservice(){

return  new SpuInfoServiceImpl(); 
    }



}