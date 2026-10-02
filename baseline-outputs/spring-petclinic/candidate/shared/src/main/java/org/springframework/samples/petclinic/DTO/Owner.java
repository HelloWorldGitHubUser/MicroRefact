package org.springframework.samples.petclinic.DTO;
 import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;
import org.springframework.beans.support.MutableSortDefinition;
import org.springframework.beans.support.PropertyComparator;
import org.springframework.core.style.ToStringCreator;
public class Owner extends Person{

 private  String address;

 private  String city;

 private  String telephone;

 private  Set<Pet> pets;


public Pet getPet(String name,boolean ignoreNew){
    name = name.toLowerCase();
    for (Pet pet : getPetsInternal()) {
        if (!ignoreNew || !pet.isNew()) {
            String compName = pet.getName();
            compName = compName.toLowerCase();
            if (compName.equals(name)) {
                return pet;
            }
        }
    }
    return null;
}


public String getTelephone(){
    return this.telephone;
}


public Set<Pet> getPetsInternal(){
    if (this.pets == null) {
        this.pets = new HashSet<>();
    }
    return this.pets;
}


public List<Pet> getPets(){
    List<Pet> sortedPets = new ArrayList<>(getPetsInternal());
    PropertyComparator.sort(sortedPets, new MutableSortDefinition("name", true, true));
    return Collections.unmodifiableList(sortedPets);
}


public String getAddress(){
    return this.address;
}


public String getCity(){
    return this.city;
}


}