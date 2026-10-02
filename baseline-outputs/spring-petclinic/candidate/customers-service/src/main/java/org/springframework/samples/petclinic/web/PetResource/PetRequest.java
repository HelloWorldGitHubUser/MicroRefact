package org.springframework.samples.petclinic.web.PetResource;
 import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.samples.petclinic.model.Owner;
import org.springframework.samples.petclinic.model.Pet;
import org.springframework.samples.petclinic.model.PetType;
import org.springframework.samples.petclinic.service.ClinicService;
import org.springframework.samples.petclinic.web.dto.DtoMapper;
import org.springframework.samples.petclinic.web.dto.PetDetails;
import org.springframework.samples.petclinic.web.dto.PetTypeDetails;
import org.springframework.web.bind.annotation;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
public class PetRequest {

 private int id;

@JsonFormat(pattern = "yyyy-MM-dd")
 private Date birthDate;

@Size(min = 1)
 private String name;

 private int typeId;


public void setName(String name){
    this.name = name;
}


public String getName(){
    return name;
}


public void setId(int id){
    this.id = id;
}


public int getId(){
    return id;
}


public Date getBirthDate(){
    return birthDate;
}


public void setBirthDate(Date birthDate){
    this.birthDate = birthDate;
}


public void setTypeId(int typeId){
    this.typeId = typeId;
}


public int getTypeId(){
    return typeId;
}


}