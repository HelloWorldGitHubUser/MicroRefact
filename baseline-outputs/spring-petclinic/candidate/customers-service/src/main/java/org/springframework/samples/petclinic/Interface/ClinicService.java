package org.springframework.samples.petclinic.Interface;
public interface ClinicService {

   public Collection<PetType> findPetTypes();
   public Object stream(Object Object);
   public Object map(Object Object);
   public Owner findOwnerById(int id);
   public Pet findPetById(int id);
   public void savePet(Pet pet);
}