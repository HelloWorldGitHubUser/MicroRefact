package org.springframework.samples.petclinic.repository;
 import java.util.Collection;
import org.springframework.dao.DataAccessException;
import org.springframework.data.repository.Repository;
import org.springframework.samples.petclinic.model.Vet;
public interface VetRepository extends Repository<Vet, Integer>{


public Collection<Vet> findAll() throws DataAccessException
;

}