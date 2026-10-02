package org.springframework.samples.petclinic.Request.Impl;
 import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.DTO.Visit;
import org.springframework.samples.petclinic.Request.VisitRequest;
public class VisitRequestImpl implements VisitRequest{

 private RestTemplate restTemplate = new RestTemplate();;


public Set<Visit> getVisitsInternal(Integer id){
 Set<Visit> aux = restTemplate.getForObject("http://1/Pet/{id}/Visit/getVisitsInternal",Set<Visit>.class,id);
return aux;
}


public void setVisitsInternal(Set<Visit> visits,Integer id){
 restTemplate.put("http://1/Pet/{id}/Visit/setVisitsInternal",visits,id);
 return ;
}


public void addVisit(Visit visit,Integer id){
 restTemplate.put("http://1/Pet/{id}/Visit/addVisit",visit,id);
 return ;
}


}