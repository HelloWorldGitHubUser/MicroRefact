package org.springframework.samples.petclinic.Interface;
 import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.Interface.VisitRepository;
public class VisitRepositoryImpl implements VisitRepository{

@Autowired
 private RestTemplate restTemplate;

  String url = "http://1";


public void save(Visit visit){
  UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url.concat("/save"))
    .queryParam("visit",visit)
;
  restTemplate.put(builder.toUriString(), null);
}


public List<Visit> findByPetIdIn(Collection<Integer> petIds){
  UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url.concat("/findByPetIdIn"))
    .queryParam("petIds",petIds)
;  List<Visit> aux = restTemplate.getForObject(builder.toUriString(), List<Visit>.class);

 return aux;
}


}