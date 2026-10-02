package ltd.newbee.mall.api.Interface;
 import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import ltd.newbee.mall.api.Interface.NewBeeMallShoppingCartService;
public class NewBeeMallShoppingCartServiceImpl implements NewBeeMallShoppingCartService{

@Autowired
 private RestTemplate restTemplate;

  String url = "http://3";


public List<NewBeeMallShoppingCartItemVO> getCartItemsForSettle(List<Long> cartItemIds,Long newBeeMallUserId){
  UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url.concat("/getCartItemsForSettle"))
    .queryParam("cartItemIds",cartItemIds)
    .queryParam("newBeeMallUserId",newBeeMallUserId)
;  List<NewBeeMallShoppingCartItemVO> aux = restTemplate.getForObject(builder.toUriString(), List<NewBeeMallShoppingCartItemVO>.class);

 return aux;
}


}