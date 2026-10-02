package com.youlai.mall.Interface;
 import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import com.youlai.mall.Interface.UmsMemberService;
public class UmsMemberServiceImpl implements UmsMemberService{

@Autowired
 private RestTemplate restTemplate;

  String url = "http://3";


public MemberAuthDTO loadUserByMobile(String mobile){
  UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url.concat("/loadUserByMobile"))
    .queryParam("mobile",mobile)
;  MemberAuthDTO aux = restTemplate.getForObject(builder.toUriString(), MemberAuthDTO.class);

 return aux;
}


public MemberAuthDTO loadUserByOpenId(String openid){
  UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url.concat("/loadUserByOpenId"))
    .queryParam("openid",openid)
;  MemberAuthDTO aux = restTemplate.getForObject(builder.toUriString(), MemberAuthDTO.class);

 return aux;
}


public Long registerMember(MemberRegisterDto dto){
  UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url.concat("/registerMember"))
    .queryParam("dto",dto)
;  Long aux = restTemplate.getForObject(builder.toUriString(), Long.class);

 return aux;
}


}