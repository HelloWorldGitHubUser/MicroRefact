package ltd.newbee.mall.api.Interface;
 import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import ltd.newbee.mall.api.Interface.NewBeeMallShoppingCartItemMapper;
public class NewBeeMallShoppingCartItemMapperImpl implements NewBeeMallShoppingCartItemMapper{

@Autowired
 private RestTemplate restTemplate;

  String url = "http://3";


public int deleteBatch(List<Long> ids){
  UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url.concat("/deleteBatch"))
    .queryParam("ids",ids)
;  int aux = restTemplate.getForObject(builder.toUriString(), int.class);

 return aux;
}


}