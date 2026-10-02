package com.goodskill.Interface;
 import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import com.goodskill.Interface.OrderServiceImpl;
public class OrderServiceImplImpl implements OrderServiceImpl{

@Autowired
 private RestTemplate restTemplate;

  String url = "http://3";


public Long count(long seckillId){
  UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url.concat("/count"))
    .queryParam("seckillId",seckillId)
;  Long aux = restTemplate.getForObject(builder.toUriString(), Long.class);

 return aux;
}


}