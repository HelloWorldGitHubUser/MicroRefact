package io.gulimall.Interface;
 import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import io.gulimall.Interface.SeckillSessionService;
public class SeckillSessionServiceImpl implements SeckillSessionService{

@Autowired
 private RestTemplate restTemplate;

  String url = "http://2";


public List<SeckillSessionEntity> getSeckillSessionsIn3Days(){
  UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url.concat("/getSeckillSessionsIn3Days"))
;  List<SeckillSessionEntity> aux = restTemplate.getForObject(builder.toUriString(), List<SeckillSessionEntity>.class);

 return aux;
}


}