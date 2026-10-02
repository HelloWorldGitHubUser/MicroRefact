package io.gulimall.Interface;
 import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import io.gulimall.Interface.SkuFullReductionService;
public class SkuFullReductionServiceImpl implements SkuFullReductionService{

@Autowired
 private RestTemplate restTemplate;

  String url = "http://2";


}