package com.central.Interface;
 import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import com.central.Interface.ISearchService;
public class ISearchServiceImpl implements ISearchService{

@Autowired
 private RestTemplate restTemplate;

  String url = "http://4";


public PageResult<JsonNode> strQuery(String indexName,SearchDto searchDto,LogicDelDto logicDelDto){
  UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url.concat("/strQuery"))
    .queryParam("indexName",indexName)
    .queryParam("searchDto",searchDto)
    .queryParam("logicDelDto",logicDelDto)
;  PageResult<JsonNode> aux = restTemplate.getForObject(builder.toUriString(), PageResult<JsonNode>.class);

 return aux;
}


}