package com.lakesidemutual.Interface;
 import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import com.lakesidemutual.Interface.CustomerId;
public class CustomerIdImpl implements CustomerId{

@Autowired
 private RestTemplate restTemplate;

  String url = "http://4";


}