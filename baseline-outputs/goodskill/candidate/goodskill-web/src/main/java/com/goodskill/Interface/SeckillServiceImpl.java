package com.goodskill.Interface;
 import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import com.goodskill.Interface.SeckillService;
public class SeckillServiceImpl implements SeckillService{

@Autowired
 private RestTemplate restTemplate;

  String url = "http://4";


public long getSuccessKillCount(Long seckillId){
  UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url.concat("/getSuccessKillCount"))
    .queryParam("seckillId",seckillId)
;  long aux = restTemplate.getForObject(builder.toUriString(), long.class);

 return aux;
}


public boolean endSeckill(Long seckillId){
  UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url.concat("/endSeckill"))
    .queryParam("seckillId",seckillId)
;  boolean aux = restTemplate.getForObject(builder.toUriString(), boolean.class);

 return aux;
}


}