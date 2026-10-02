package com.lakesidemutual.Interface;
 import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import com.lakesidemutual.Interface.CityLookupService;
public class CityLookupServiceImpl implements CityLookupService{

@Autowired
 private RestTemplate restTemplate;

  String url = "http://0";


public List<String> getCitiesForPostalCode(String postalCode){
  UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url.concat("/getCitiesForPostalCode"))
    .queryParam("postalCode",postalCode)
;  List<String> aux = restTemplate.getForObject(builder.toUriString(), List<String>.class);

 return aux;
}


}