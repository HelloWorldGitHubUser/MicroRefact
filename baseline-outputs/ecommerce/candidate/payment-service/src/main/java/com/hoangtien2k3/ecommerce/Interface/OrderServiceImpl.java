package com.hoangtien2k3.ecommerce.Interface;
 import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import com.hoangtien2k3.ecommerce.Interface.OrderService;
public class OrderServiceImpl implements OrderService{

@Autowired
 private RestTemplate restTemplate;

  String url = "http://1";


public OrderDto findById(Integer orderId){
  UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url.concat("/findById"))
    .queryParam("orderId",orderId)
;  OrderDto aux = restTemplate.getForObject(builder.toUriString(), OrderDto.class);

 return aux;
}


}