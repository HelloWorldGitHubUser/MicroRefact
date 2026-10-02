package org.springframework.samples.petclinic.NEWInstance;
 import org.springframework.web.bind.annotation.*;
@RestController
@CrossOrigin
public class VisitRepositoryController {

 private VisitRepository visitrepository;


@PutMapping
("/save")
public void save(@RequestParam(name = "visit") Visit visit){
visitrepository.save(visit);
}


@GetMapping
("/findByPetIdIn")
public List<Visit> findByPetIdIn(@RequestParam(name = "petIds") Collection<Integer> petIds){
  return visitrepository.findByPetIdIn(petIds);
}


}