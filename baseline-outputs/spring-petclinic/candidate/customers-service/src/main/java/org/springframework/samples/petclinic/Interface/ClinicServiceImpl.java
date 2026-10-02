package org.springframework.samples.petclinic.Interface;
 import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.Interface.ClinicService;
public class ClinicServiceImpl implements ClinicService{

@Autowired
 private RestTemplate restTemplate;

  String url = "http://4";


public Collection<PetType> findPetTypes(){
  UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url.concat("/findPetTypes"))
;  Collection<PetType> aux = restTemplate.getForObject(builder.toUriString(), Collection<PetType>.class);

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


public Owner findOwnerById(int id){
  UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url.concat("/findOwnerById"))
    .queryParam("id",id)
;  Owner aux = restTemplate.getForObject(builder.toUriString(), Owner.class);

 return aux;
}


public Pet findPetById(int id){
  UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url.concat("/findPetById"))
    .queryParam("id",id)
;  Pet aux = restTemplate.getForObject(builder.toUriString(), Pet.class);

 return aux;
}


public void savePet(Pet pet){
  UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url.concat("/savePet"))
    .queryParam("pet",pet)
;
  restTemplate.put(builder.toUriString(), null);
}


}