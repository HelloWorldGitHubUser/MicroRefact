package io.gulimall.Interface;
 import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import io.gulimall.Interface.SpuBoundsService;
public class SpuBoundsServiceImpl implements SpuBoundsService{

@Autowired
 private RestTemplate restTemplate;

  String url = "http://2";


}