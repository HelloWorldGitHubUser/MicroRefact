package com.central.Interface;
 import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import com.central.Interface.LogicDelDto;
public class LogicDelDtoImpl implements LogicDelDto{

@Autowired
 private RestTemplate restTemplate;

  String url = "http://4";


}