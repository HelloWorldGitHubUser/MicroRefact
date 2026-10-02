package org.springframework.samples.petclinic.Interface;
public interface PetRepository {

   public List<PetType> findPetTypes();
   public Pet findById(int id);
   public void save(Pet pet);
}