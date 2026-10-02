package io.gulimall.Interface;
 import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import io.gulimall.Interface.SkuSaleAttrValueService;
public class SkuSaleAttrValueServiceImpl implements SkuSaleAttrValueService{

@Autowired
 private RestTemplate restTemplate;

  String url = "http://5";


public List<String> getSkuSaleAttrValuesAsString(Long skuId){
  UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url.concat("/getSkuSaleAttrValuesAsString"))
    .queryParam("skuId",skuId)
;  List<String> aux = restTemplate.getForObject(builder.toUriString(), List<String>.class);

 return aux;
}


}