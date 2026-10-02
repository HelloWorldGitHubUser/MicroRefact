package org.springframework.samples.petclinic.NEW;
 import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.repository.PetRepository;
import org.springframework.samples.petclinic.model.Pet;
@Service
public class PetVisitService {

@Autowired
 private PetRepository petrepository;


public Pet getPet(Integer idY0CQ){
return petrepository.getPet(idY0CQ);
}


public void setPet(Integer idY0CQ,Pet pet){
petrepository.setPet(idY0CQ,pet);
}


}