package org.springframework.samples.petclinic.Interface;
 import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.Interface.PetRepository;
public class PetRepositoryImpl implements PetRepository{

@Autowired
 private RestTemplate restTemplate;

  String url = "http://0";


public List<PetType> findPetTypes(){
  UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url.concat("/findPetTypes"))
;  List<PetType> aux = restTemplate.getForObject(builder.toUriString(), List<PetType>.class);

 return aux;
}


public Pet findById(int id){
  UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url.concat("/findById"))
    .queryParam("id",id)
;  Pet aux = restTemplate.getForObject(builder.toUriString(), Pet.class);

 return aux;
}


public void save(Pet pet){
  UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url.concat("/save"))
    .queryParam("pet",pet)
;
  restTemplate.put(builder.toUriString(), null);
}


}