package io.gulimall.Interface;
 import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import io.gulimall.Interface.MemberService;
public class MemberServiceImpl implements MemberService{

@Autowired
 private RestTemplate restTemplate;

  String url = "http://3";


public MemberEntity login(SocialUser socialUser){
  UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url.concat("/login"))
    .queryParam("socialUser",socialUser)
;  MemberEntity aux = restTemplate.getForObject(builder.toUriString(), MemberEntity.class);

 return aux;
}


}