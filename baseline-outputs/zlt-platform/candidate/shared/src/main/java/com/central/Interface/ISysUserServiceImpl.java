package com.central.Interface;
 import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import com.central.Interface.ISysUserService;
public class ISysUserServiceImpl implements ISysUserService{

@Autowired
 private RestTemplate restTemplate;

  String url = "http://0";


public Object getById(Object Object){
  UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url.concat("/getById"))
    .queryParam("Object",Object)
;  Object aux = restTemplate.getForObject(builder.toUriString(), Object.class);

 return aux;
}


public void setUserPermission(SysUser sysUser){
  UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url.concat("/setUserPermission"))
    .queryParam("sysUser",sysUser)
;
  restTemplate.put(builder.toUriString(), null);
}


}