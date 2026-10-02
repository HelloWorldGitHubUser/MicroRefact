package org.springframework.samples.petclinic.Interface;
public interface VetRepository {

   public Collection<Vet> findAll();
}