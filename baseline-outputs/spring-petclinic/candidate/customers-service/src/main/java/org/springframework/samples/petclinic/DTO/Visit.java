package org.springframework.samples.petclinic.DTO;
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
public class Visit extends BaseEntity{

 private  Date date;

 private  String description;

 private  Pet pet;

/**
 * Creates a new instance of Visit for the current date
 */
public Visit() {
    this.date = new Date();
}
public Pet getPet(){
    return this.pet;
}


public Date getDate(){
    return this.date;
}


public String getDescription(){
    return this.description;
}


}