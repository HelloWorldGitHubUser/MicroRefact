package org.springframework.samples.petclinic.model;
 import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import java.util.Date;
import org.springframework.samples.petclinic.Request.PetRequest;
import org.springframework.samples.petclinic.Request.Impl.PetRequestImpl;
import org.springframework.samples.petclinic.DTO.Pet;
@Entity
@Table(name = "visits")
public class Visit extends BaseEntity{

@Column(name = "visit_date")
@Temporal(TemporalType.TIMESTAMP)
@JsonFormat(pattern = "yyyy-MM-dd")
 private  Date date;

@Size(max = 8192)
@Column(name = "description")
 private  String description;

@Transient
 private  Pet pet;

@Column(name = "idY0CQ")
 private Integer idY0CQ;

@Transient
 private PetRequest petrequest = new PetRequestImpl();;

/**
 * Creates a new instance of Visit for the current date
 */
public Visit() {
    this.date = new Date();
}
public Pet getPet(){
  this.pet = petrequest.getPet(this.idY0CQ);
return this.pet;
}}



public void setDate(Date date){
    this.date = date;
}


public Date getDate(){
    return this.date;
}


public void setDescription(String description){
    this.description = description;
}


public String getDescription(){
    return this.description;
}


public void setPet(Pet pet){
this.idY0CQ = pet.getPet() ;
petrequest.setPet(pet,this.idY0CQ);
 this.pet = pet;
}



}