package ltd.newbee.mall.api.Interface;
 import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import ltd.newbee.mall.api.Interface.NewBeeAdminUserTokenMapper;
public class NewBeeAdminUserTokenMapperImpl implements NewBeeAdminUserTokenMapper{

@Autowired
 private RestTemplate restTemplate;

  String url = "http://0";


public AdminUserToken selectByToken(String token){
  UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url.concat("/selectByToken"))
    .queryParam("token",token)
;  AdminUserToken aux = restTemplate.getForObject(builder.toUriString(), AdminUserToken.class);

 return aux;
}


}