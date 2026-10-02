package org.springframework.samples.petclinic.Interface;
 import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.Interface.VetRepository;
public class VetRepositoryImpl implements VetRepository{

@Autowired
 private RestTemplate restTemplate;

  String url = "http://2";


public Collection<Vet> findAll(){
  UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url.concat("/findAll"))
;  Collection<Vet> aux = restTemplate.getForObject(builder.toUriString(), Collection<Vet>.class);

 return aux;
}


}