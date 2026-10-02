package com.youlai.mall.Interface;
 import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import com.youlai.mall.Interface.SysUserService;
public class SysUserServiceImpl implements SysUserService{

@Autowired
 private RestTemplate restTemplate;

  String url = "http://5";


public UserAuthInfo getUserAuthInfo(String username){
  UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url.concat("/getUserAuthInfo"))
    .queryParam("username",username)
;  UserAuthInfo aux = restTemplate.getForObject(builder.toUriString(), UserAuthInfo.class);

 return aux;
}


}