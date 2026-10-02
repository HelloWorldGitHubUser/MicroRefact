package org.springframework.samples.petclinic.model;
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
@Entity
@Table(name = "pets")
public class Pet extends NamedEntity{

@Column(name = "birth_date")
@Temporal(TemporalType.DATE)
 private  Date birthDate;

@ManyToOne
@JoinColumn(name = "type_id")
 private  PetType type;

@ManyToOne
@JoinColumn(name = "owner_id")
@JsonIgnore
 private  Owner owner;

@Transient
 private  Set<Visit> visits;

@Transient
 private VisitRequest visitrequest = new VisitRequestImpl();;


public Set<Visit> getVisitsInternal(){
  this.visits = visitrequest.getVisitsInternal(this.id);
return this.visits;
}}



public PetType getType(){
    return this.type;
}


public void setVisitsInternal(Set<Visit> visits){
visitrequest.setVisitsInternal(visits,this.id);
 this.visits = visits;
}



public void addVisit(Visit visit){
visitrequest.addVisit(visit,this.id);
}



public void setBirthDate(Date birthDate){
    this.birthDate = birthDate;
}


public Date getBirthDate(){
    return this.birthDate;
}


public void setType(PetType type){
    this.type = type;
}


public Owner getOwner(){
    return this.owner;
}


public void setOwner(Owner owner){
    this.owner = owner;
}


public List<Visit> getVisits(){
    List<Visit> sortedVisits = new ArrayList<>(getVisitsInternal());
    PropertyComparator.sort(sortedVisits, new MutableSortDefinition("date", false, false));
    return Collections.unmodifiableList(sortedVisits);
}


}