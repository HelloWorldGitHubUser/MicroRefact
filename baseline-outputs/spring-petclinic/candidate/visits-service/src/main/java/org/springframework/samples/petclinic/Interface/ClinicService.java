package org.springframework.samples.petclinic.Interface;
public interface ClinicService {

   public Pet findPetById(int id);
   public void saveVisit(Visit visit);
   public List<Visit> findVisitsByPetIds(Collection<Integer> petIds);
}