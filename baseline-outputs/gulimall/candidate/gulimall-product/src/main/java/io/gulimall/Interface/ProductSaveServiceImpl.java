package io.gulimall.Interface;
 import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import io.gulimall.Interface.ProductSaveService;
public class ProductSaveServiceImpl implements ProductSaveService{

@Autowired
 private RestTemplate restTemplate;

  String url = "http://6";


}