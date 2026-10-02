package com.youlai.mall.Interface;
 import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import com.youlai.mall.Interface.SmsService;
public class SmsServiceImpl implements SmsService{

@Autowired
 private RestTemplate restTemplate;

  String url = "http://6";


}