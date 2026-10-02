package org.springframework.samples.petclinic.Interface;
 import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.Interface.ClinicService;
public class ClinicServiceImpl implements ClinicService{

@Autowired
 private RestTemplate restTemplate;

  String url = "http://4";


public Collection<Vet> findVets(){
  UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url.concat("/findVets"))
;  Collection<Vet> aux = restTemplate.getForObject(builder.toUriString(), Collection<Vet>.class);

 return aux;
}


public Object stream(Object Object){
  UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url.concat("/stream"))
    .queryParam("Object",Object)
;  Object aux = restTemplate.getForObject(builder.toUriString(), Object.class);

 return aux;
}


public Object map(Object Object){
  UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url.concat("/map"))
    .queryParam("Object",Object)
;  Object aux = restTemplate.getForObject(builder.toUriString(), Object.class);

 return aux;
}


}