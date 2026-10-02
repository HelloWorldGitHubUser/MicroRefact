package com.goodskill.Interface;
 import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import com.goodskill.Interface.SeckillMockResponseListener;
public class SeckillMockResponseListenerImpl implements SeckillMockResponseListener{

@Autowired
 private RestTemplate restTemplate;

  String url = "http://5";


public void handleSeckillResult(SeckillMockResponseDTO responseDto){
  UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url.concat("/handleSeckillResult"))
    .queryParam("responseDto",responseDto)
;
  restTemplate.put(builder.toUriString(), null);
}


}