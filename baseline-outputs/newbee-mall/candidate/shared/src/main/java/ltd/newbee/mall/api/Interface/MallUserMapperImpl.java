package ltd.newbee.mall.api.Interface;
 import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import ltd.newbee.mall.api.Interface.MallUserMapper;
public class MallUserMapperImpl implements MallUserMapper{

@Autowired
 private RestTemplate restTemplate;

  String url = "http://0";


public MallUser selectByPrimaryKey(Long userId){
  UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url.concat("/selectByPrimaryKey"))
    .queryParam("userId",userId)
;  MallUser aux = restTemplate.getForObject(builder.toUriString(), MallUser.class);

 return aux;
}


}