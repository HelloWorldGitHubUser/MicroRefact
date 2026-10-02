package org.springframework.samples.petclinic.repository;
 import java.util.List;
import java.util.Collection;
import org.springframework.dao.DataAccessException;
import org.springframework.data.repository.Repository;
import org.springframework.samples.petclinic.model.BaseEntity;
import org.springframework.samples.petclinic.model.Visit;
public interface VisitRepository extends Repository<Visit, Integer>{


public List<Visit> findByPetId(Integer petId)
;

public List<Visit> findByPetIdIn(Collection<Integer> petIds)
;

public void save(Visit visit) throws DataAccessException
;

public Set<Visit> getVisitsInternal(Integer id);

public void setVisitsInternal(Integer id,Set<Visit> visits);

public void addVisit(Integer id,Visit visit);

}