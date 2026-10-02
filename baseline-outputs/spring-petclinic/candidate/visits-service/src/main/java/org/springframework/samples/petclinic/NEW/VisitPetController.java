package org.springframework.samples.petclinic.NEW;
 import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.model.Visit;
@RestController
@CrossOrigin
public class VisitPetController {

@Autowired
 private VisitPetService visitpetservice;


@GetMapping
("/Pet/{id}/Visit/getVisitsInternal")
public Set<Visit> getVisitsInternal(@PathVariable(name="id") Integer id){
return visitpetservice.getVisitsInternal(id);
}


@PutMapping
("/Pet/{id}/Visit/setVisitsInternal")
public void setVisitsInternal(@PathVariable(name="id") Integer id,@RequestBody Set<Visit> visits){
visitpetservice.setVisitsInternal(id,visits);
}


@PutMapping
("/Pet/{id}/Visit/addVisit")
public void addVisit(@PathVariable(name="id") Integer id,@RequestBody Visit visit){
visitpetservice.addVisit(id,visit);
}


}