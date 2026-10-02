package org.springframework.samples.petclinic.NEW;
 import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.model.Pet;
@RestController
@CrossOrigin
public class PetVisitController {

@Autowired
 private PetVisitService petvisitservice;


@GetMapping
("/Visit/{id}/Pet/getPet")
public Pet getPet(@PathVariable(name="id") Integer idY0CQ){
return petvisitservice.getPet(idY0CQ);
}


@PutMapping
("/Visit/{id}/Pet/setPet")
public void setPet(@PathVariable(name="id") Integer idY0CQ,@RequestBody Pet pet){
petvisitservice.setPet(idY0CQ,pet);
}


}