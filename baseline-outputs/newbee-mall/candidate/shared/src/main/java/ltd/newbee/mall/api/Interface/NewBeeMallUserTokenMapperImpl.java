package ltd.newbee.mall.api.Interface;
 import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import ltd.newbee.mall.api.Interface.NewBeeMallUserTokenMapper;
public class NewBeeMallUserTokenMapperImpl implements NewBeeMallUserTokenMapper{

@Autowired
 private RestTemplate restTemplate;

  String url = "http://0";


public MallUserToken selectByToken(String token){
  UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url.concat("/selectByToken"))
    .queryParam("token",token)
;  MallUserToken aux = restTemplate.getForObject(builder.toUriString(), MallUserToken.class);

 return aux;
}


}