package org.springframework.samples.petclinic.DTO;
 import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.beans.support.MutableSortDefinition;
import org.springframework.beans.support.PropertyComparator;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.samples.petclinic.Request.VisitRequest;
import org.springframework.samples.petclinic.Request.Impl.VisitRequestImpl;
import org.springframework.samples.petclinic.DTO.Visit;
public class Pet extends NamedEntity{

 private  Date birthDate;

 private  PetType type;

 private  Owner owner;

 private  Set<Visit> visits;


public Set<Visit> getVisitsInternal(){
  this.visits = visitrequest.getVisitsInternal(this.id);
return this.visits;
}}



public PetType getType(){
    return this.type;
}


public Date getBirthDate(){
    return this.birthDate;
}


public Owner getOwner(){
    return this.owner;
}


public List<Visit> getVisits(){
    List<Visit> sortedVisits = new ArrayList<>(getVisitsInternal());
    PropertyComparator.sort(sortedVisits, new MutableSortDefinition("date", false, false));
    return Collections.unmodifiableList(sortedVisits);
}


}