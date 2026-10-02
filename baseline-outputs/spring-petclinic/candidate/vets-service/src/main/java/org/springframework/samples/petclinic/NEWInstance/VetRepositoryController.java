package org.springframework.samples.petclinic.NEWInstance;
 import org.springframework.web.bind.annotation.*;
@RestController
@CrossOrigin
public class VetRepositoryController {

 private VetRepository vetrepository;


@GetMapping
("/findAll")
public Collection<Vet> findAll(){
  return vetrepository.findAll();
}


}