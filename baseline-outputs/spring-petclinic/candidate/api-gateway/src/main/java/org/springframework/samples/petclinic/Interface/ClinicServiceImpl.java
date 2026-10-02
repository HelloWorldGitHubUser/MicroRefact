package org.springframework.samples.petclinic.Interface;
 import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.Interface.ClinicService;
public class ClinicServiceImpl implements ClinicService{

@Autowired
 private RestTemplate restTemplate;

  String url = "http://4";


public Owner findOwnerById(int id){
  UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url.concat("/findOwnerById"))
    .queryParam("id",id)
;  Owner aux = restTemplate.getForObject(builder.toUriString(), Owner.class);

 return aux;
}


}