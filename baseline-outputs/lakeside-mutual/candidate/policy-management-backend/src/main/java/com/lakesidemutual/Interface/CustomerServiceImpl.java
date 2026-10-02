package com.lakesidemutual.Interface;
 import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import com.lakesidemutual.Interface.CustomerService;
public class CustomerServiceImpl implements CustomerService{

@Autowired
 private RestTemplate restTemplate;

  String url = "http://0";


public Page<CustomerAggregateRoot> getCustomers(String filter,int limit,int offset){
  UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url.concat("/getCustomers"))
    .queryParam("filter",filter)
    .queryParam("limit",limit)
    .queryParam("offset",offset)
;  Page<CustomerAggregateRoot> aux = restTemplate.getForObject(builder.toUriString(), Page<CustomerAggregateRoot>.class);

 return aux;
}


}