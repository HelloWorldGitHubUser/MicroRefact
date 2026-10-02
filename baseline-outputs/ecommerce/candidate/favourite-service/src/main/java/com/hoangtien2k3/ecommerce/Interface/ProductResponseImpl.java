package com.hoangtien2k3.ecommerce.Interface;
 import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import com.hoangtien2k3.ecommerce.Interface.ProductResponse;
public class ProductResponseImpl implements ProductResponse{

@Autowired
 private RestTemplate restTemplate;

  String url = "http://13";


}