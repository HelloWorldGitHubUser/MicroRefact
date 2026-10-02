package org.springframework.samples.petclinic.repository;
 import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.samples.petclinic.model.Pet;
import org.springframework.samples.petclinic.model.PetType;
public interface PetRepository extends Repository<Pet, Integer>{


public Pet findById(int id)
;

public void save(Pet pet)
;

@Query("SELECT ptype FROM PetType ptype ORDER BY ptype.name")
public List<PetType> findPetTypes()
;

public Pet getPet(Integer idY0CQ);

public void setPet(Integer idY0CQ,Pet pet);

}