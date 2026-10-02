package org.springframework.samples.petclinic.repository;
 import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.samples.petclinic.model.Owner;
public interface OwnerRepository extends JpaRepository<Owner, Integer>{


}