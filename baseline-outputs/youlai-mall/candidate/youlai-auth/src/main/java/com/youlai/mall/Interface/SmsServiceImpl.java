package com.youlai.mall.Interface;
 import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import com.youlai.mall.Interface.SmsService;
public class SmsServiceImpl implements SmsService{

@Autowired
 private RestTemplate restTemplate;

  String url = "http://6";


public boolean sendSms(String mobile,String templateCode,String templateParam){
  UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url.concat("/sendSms"))
    .queryParam("mobile",mobile)
    .queryParam("templateCode",templateCode)
    .queryParam("templateParam",templateParam)
;  boolean aux = restTemplate.getForObject(builder.toUriString(), boolean.class);

 return aux;
}


}