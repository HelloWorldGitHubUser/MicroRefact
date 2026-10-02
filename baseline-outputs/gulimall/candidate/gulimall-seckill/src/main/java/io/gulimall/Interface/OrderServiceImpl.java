package io.gulimall.Interface;
 import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import io.gulimall.Interface.OrderService;
public class OrderServiceImpl implements OrderService{

@Autowired
 private RestTemplate restTemplate;

  String url = "http://4";


public void createSeckillOrder(SeckillOrderTo orderTo){
  UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url.concat("/createSeckillOrder"))
    .queryParam("orderTo",orderTo)
;
  restTemplate.put(builder.toUriString(), null);
}


}