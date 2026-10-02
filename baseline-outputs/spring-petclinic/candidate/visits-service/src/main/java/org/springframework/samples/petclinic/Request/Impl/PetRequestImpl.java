package org.springframework.samples.petclinic.Request.Impl;
 import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.DTO.Pet;
import org.springframework.samples.petclinic.Request.PetRequest;
public class PetRequestImpl implements PetRequest{

 private RestTemplate restTemplate = new RestTemplate();;


public Pet getPet(Integer idY0CQ){
 Pet aux = restTemplate.getForObject("http://0/Visit/{id}/Pet/getPet",Pet.class,idY0CQ);
return aux;
}


public void setPet(Pet pet,Integer idY0CQ){
 restTemplate.put("http://0/Visit/{id}/Pet/setPet",pet,idY0CQ);
 return ;
}


}