package com.central.Interface;
 import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import com.central.Interface.IAggregationService;
public class IAggregationServiceImpl implements IAggregationService{

@Autowired
 private RestTemplate restTemplate;

  String url = "http://4";


public Map<String,Object> getDefaultStatData(){
  UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url.concat("/getDefaultStatData"))
;  Map<String,Object> aux = restTemplate.getForObject(builder.toUriString(), Map<String,Object>.class);

 return aux;
}


public Map<String,Object> requestStatAgg(String indexName,String routing){
  UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url.concat("/requestStatAgg"))
    .queryParam("indexName",indexName)
    .queryParam("routing",routing)
;  Map<String,Object> aux = restTemplate.getForObject(builder.toUriString(), Map<String,Object>.class);

 return aux;
}


}