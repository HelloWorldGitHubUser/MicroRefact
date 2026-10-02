package com.hoangtien2k3.ecommerce.Interface;
 import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import com.hoangtien2k3.ecommerce.Interface.JwtEntryPoint;
public class JwtEntryPointImpl implements JwtEntryPoint{

@Autowired
 private RestTemplate restTemplate;

  String url = "http://0";


}