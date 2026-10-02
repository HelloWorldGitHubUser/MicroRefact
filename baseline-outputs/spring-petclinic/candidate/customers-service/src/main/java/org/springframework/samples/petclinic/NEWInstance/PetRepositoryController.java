package org.springframework.samples.petclinic.NEWInstance;
 import org.springframework.web.bind.annotation.*;
@RestController
@CrossOrigin
public class PetRepositoryController {

 private PetRepository petrepository;


@GetMapping
("/findPetTypes")
public List<PetType> findPetTypes(){
  return petrepository.findPetTypes();
}


@GetMapping
("/findById")
public Pet findById(@RequestParam(name = "id") int id){
  return petrepository.findById(id);
}


@PutMapping
("/save")
public void save(@RequestParam(name = "pet") Pet pet){
petrepository.save(pet);
}


}