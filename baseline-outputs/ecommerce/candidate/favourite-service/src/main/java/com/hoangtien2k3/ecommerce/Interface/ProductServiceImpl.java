package com.hoangtien2k3.ecommerce.Interface;
 import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import com.hoangtien2k3.ecommerce.Interface.ProductService;
public class ProductServiceImpl implements ProductService{

@Autowired
 private RestTemplate restTemplate;

  String url = "http://2";


public ProductDto findById(Integer productId){
  UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url.concat("/findById"))
    .queryParam("productId",productId)
;  ProductDto aux = restTemplate.getForObject(builder.toUriString(), ProductDto.class);

 return aux;
}


}