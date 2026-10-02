package org.springframework.samples.petclinic.NEWInstance;
 import org.springframework.web.bind.annotation.*;
@RestController
@CrossOrigin
public class ClinicServiceController {

 private ClinicService clinicservice;


@GetMapping
("/findOwnerById")
public Owner findOwnerById(@RequestParam(name = "id") int id){
  return clinicservice.findOwnerById(id);
}


@PutMapping
("/saveOwner")
public void saveOwner(@RequestParam(name = "owner") Owner owner){
clinicservice.saveOwner(owner);
}


@GetMapping
("/findAll")
public Collection<Owner> findAll(){
  return clinicservice.findAll();
}


@GetMapping
("/stream")
public Object stream(@RequestParam(name = "Object") Object Object){
  return clinicservice.stream(Object);
}


@GetMapping
("/map")
public Object map(@RequestParam(name = "Object") Object Object){
  return clinicservice.map(Object);
}


@GetMapping
("/findPetTypes")
public Collection<PetType> findPetTypes(){
  return clinicservice.findPetTypes();
}


@GetMapping
("/findPetById")
public Pet findPetById(@RequestParam(name = "id") int id){
  return clinicservice.findPetById(id);
}


@PutMapping
("/savePet")
public void savePet(@RequestParam(name = "pet") Pet pet){
clinicservice.savePet(pet);
}


@PutMapping
("/saveVisit")
public void saveVisit(@RequestParam(name = "visit") Visit visit){
clinicservice.saveVisit(visit);
}


@GetMapping
("/findVisitsByPetIds")
public List<Visit> findVisitsByPetIds(@RequestParam(name = "petIds") Collection<Integer> petIds){
  return clinicservice.findVisitsByPetIds(petIds);
}


@GetMapping
("/findVets")
public Collection<Vet> findVets(){
  return clinicservice.findVets();
}


}