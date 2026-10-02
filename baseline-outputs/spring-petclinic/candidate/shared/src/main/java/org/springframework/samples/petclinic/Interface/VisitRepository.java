package org.springframework.samples.petclinic.Interface;
public interface VisitRepository {

   public void save(Visit visit);
   public List<Visit> findByPetIdIn(Collection<Integer> petIds);
}