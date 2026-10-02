package io.gulimall.Interface;
 import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import io.gulimall.Interface.SmsComponent;
public class SmsComponentImpl implements SmsComponent{

@Autowired
 private RestTemplate restTemplate;

  String url = "http://9";


public void sendCode(String phone,String code){
  UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url.concat("/sendCode"))
    .queryParam("phone",phone)
    .queryParam("code",code)
;
  restTemplate.put(builder.toUriString(), null);
}


}