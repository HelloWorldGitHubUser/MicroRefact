package com.goodskill.Interface;
 import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import com.goodskill.Interface.SeckillMockController;
public class SeckillMockControllerImpl implements SeckillMockController{

@Autowired
 private RestTemplate restTemplate;

  String url = "http://5";


public Result<Long> doWithSychronized(SeckillWebMockRequestDTO dto){
  UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url.concat("/doWithSychronized"))
    .queryParam("dto",dto)
;  Result<Long> aux = restTemplate.getForObject(builder.toUriString(), Result<Long>.class);

 return aux;
}


public Result<String> getTaskTimeInfo(Long seckillId){
  UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url.concat("/getTaskTimeInfo"))
    .queryParam("seckillId",seckillId)
;  Result<String> aux = restTemplate.getForObject(builder.toUriString(), Result<String>.class);

 return aux;
}


}