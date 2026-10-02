package io.gulimall.Interface;
 import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import io.gulimall.Interface.AttrService;
public class AttrServiceImpl implements AttrService{

@Autowired
 private RestTemplate restTemplate;

  String url = "http://5";


public AttrRespVo getAttrInfo(Long attrId){
  UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url.concat("/getAttrInfo"))
    .queryParam("attrId",attrId)
;  AttrRespVo aux = restTemplate.getForObject(builder.toUriString(), AttrRespVo.class);

 return aux;
}


}