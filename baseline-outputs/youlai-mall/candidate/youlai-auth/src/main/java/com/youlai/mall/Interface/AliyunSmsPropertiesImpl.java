package com.youlai.mall.Interface;
 import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import com.youlai.mall.Interface.AliyunSmsProperties;
public class AliyunSmsPropertiesImpl implements AliyunSmsProperties{

@Autowired
 private RestTemplate restTemplate;

  String url = "http://6";


public Object getTemplateCodes(Object Object){
  UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url.concat("/getTemplateCodes"))
    .queryParam("Object",Object)
;  Object aux = restTemplate.getForObject(builder.toUriString(), Object.class);

 return aux;
}


}