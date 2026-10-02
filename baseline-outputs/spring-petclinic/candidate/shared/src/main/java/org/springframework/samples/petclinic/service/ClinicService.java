package org.springframework.samples.petclinic.service;
 import java.util.Collection;
import java.util.List;
import org.springframework.samples.petclinic.model.Owner;
import org.springframework.samples.petclinic.model.Pet;
import org.springframework.samples.petclinic.model.PetType;
import org.springframework.samples.petclinic.model.Vet;
import org.springframework.samples.petclinic.model.Visit;
public interface ClinicService {


public Owner findOwnerById(int id)
;

public Pet findPetById(int id)
;

public void savePet(Pet pet)
;

public Collection<Vet> findVets()
;

public List<Visit> findVisitsByPetIds(Collection<Integer> petIds)
;

public void saveVisit(Visit visit)
;

public Collection<Owner> findAll()
;

public Collection<PetType> findPetTypes()
;

public void saveOwner(Owner owner)
;

}