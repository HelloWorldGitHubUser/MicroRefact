package org.springframework.samples.petclinic.model;
 import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;
import org.springframework.beans.support.MutableSortDefinition;
import org.springframework.beans.support.PropertyComparator;
@Entity
@Table(name = "vets")
public class Vet extends Person{

@ManyToMany(fetch = FetchType.EAGER)
@JoinTable(name = "vet_specialties", joinColumns = @JoinColumn(name = "vet_id"), inverseJoinColumns = @JoinColumn(name = "specialty_id"))
 private  Set<Specialty> specialties;


@XmlElement
public List<Specialty> getSpecialties(){
    List<Specialty> sortedSpecs = new ArrayList<>(getSpecialtiesInternal());
    PropertyComparator.sort(sortedSpecs, new MutableSortDefinition("name", true, true));
    return Collections.unmodifiableList(sortedSpecs);
}


public Set<Specialty> getSpecialtiesInternal(){
    if (this.specialties == null) {
        this.specialties = new HashSet<>();
    }
    return this.specialties;
}


public int getNrOfSpecialties(){
    return getSpecialtiesInternal().size();
}


public void setSpecialtiesInternal(Set<Specialty> specialties){
    this.specialties = specialties;
}


public void addSpecialty(Specialty specialty){
    getSpecialtiesInternal().add(specialty);
}


}