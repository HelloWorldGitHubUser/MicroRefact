package org.springframework.samples.petclinic.Interface;
 import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.Interface.ClinicService;
public class ClinicServiceImpl implements ClinicService{

@Autowired
 private RestTemplate restTemplate;

  String url = "http://4";


public Pet findPetById(int id){
  UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url.concat("/findPetById"))
    .queryParam("id",id)
;  Pet aux = restTemplate.getForObject(builder.toUriString(), Pet.class);

 return aux;
}


public void saveVisit(Visit visit){
  UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url.concat("/saveVisit"))
    .queryParam("visit",visit)
;
  restTemplate.put(builder.toUriString(), null);
}


public List<Visit> findVisitsByPetIds(Collection<Integer> petIds){
  UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url.concat("/findVisitsByPetIds"))
    .queryParam("petIds",petIds)
;  List<Visit> aux = restTemplate.getForObject(builder.toUriString(), List<Visit>.class);

 return aux;
}


}