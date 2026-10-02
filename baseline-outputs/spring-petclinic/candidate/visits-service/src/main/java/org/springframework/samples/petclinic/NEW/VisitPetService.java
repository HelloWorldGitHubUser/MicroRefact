package org.springframework.samples.petclinic.NEW;
 import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.repository.VisitRepository;
import org.springframework.samples.petclinic.model.Visit;
@Service
public class VisitPetService {

@Autowired
 private VisitRepository visitrepository;


public Set<Visit> getVisitsInternal(Integer id){
return visitrepository.getVisitsInternal(id);
}


public void setVisitsInternal(Integer id,Set<Visit> visits){
visitrepository.setVisitsInternal(id,visits);
}


public void addVisit(Integer id,Visit visit){
visitrepository.addVisit(id,visit);
}


}