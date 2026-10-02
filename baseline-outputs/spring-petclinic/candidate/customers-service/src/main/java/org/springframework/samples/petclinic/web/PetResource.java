package org.springframework.samples.petclinic.web;
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
import org.springframework.samples.petclinic.Interface.ClinicService;
import org.springframework.samples.petclinic.DTO.ClinicService;
import org.springframework.samples.petclinic.DTO.ClinicService;
@RestController
public class PetResource extends AbstractResourceController{

 private  ClinicService clinicService;

 private int id;

@JsonFormat(pattern = "yyyy-MM-dd")
 private Date birthDate;

@Size(min = 1)
 private String name;

 private int typeId;

@Autowired
public PetResource(ClinicService clinicService) {
    this.clinicService = clinicService;
}
public void setName(String name){
    this.name = name;
}


@GetMapping({ "/owners/*/pets/{petId}", "/api/customer/owners/*/pets/{petId}" })
public PetDetails findPet(int petId){
    return DtoMapper.petDetails(this.clinicService.findPetById(petId));
}


public String getName(){
    return name;
}


public void save(Pet pet,PetRequest petRequest){
    pet.setName(petRequest.getName());
    pet.setBirthDate(petRequest.getBirthDate());
    for (PetType petType : clinicService.findPetTypes()) {
        if (petType.getId() == petRequest.getTypeId()) {
            pet.setType(petType);
        }
    }
    clinicService.savePet(pet);
}


public int getId(){
    return id;
}


public void setBirthDate(Date birthDate){
    this.birthDate = birthDate;
}


public void setTypeId(int typeId){
    this.typeId = typeId;
}


@GetMapping({ "/petTypes", "/api/customer/petTypes" })
public List<PetTypeDetails> getPetTypes(){
    return clinicService.findPetTypes().stream().map(DtoMapper::petTypeDetails).collect(Collectors.toList());
}


@PutMapping({ "/owners/{ownerId}/pets/{petId}", "/api/customer/owners/{ownerId}/pets/{petId}" })
@ResponseStatus(HttpStatus.NO_CONTENT)
public void processUpdateForm(PetRequest petRequest){
    save(clinicService.findPetById(petRequest.getId()), petRequest);
}


public int getTypeId(){
    return typeId;
}


public void setId(int id){
    this.id = id;
}


public Date getBirthDate(){
    return birthDate;
}


@PostMapping({ "/owners/{ownerId}/pets", "/api/customer/owners/{ownerId}/pets" })
@ResponseStatus(HttpStatus.CREATED)
public PetDetails processCreationForm(PetRequest petRequest,int ownerId){
    Pet pet = new Pet();
    Owner owner = this.clinicService.findOwnerById(ownerId);
    owner.addPet(pet);
    save(pet, petRequest);
    return DtoMapper.petDetails(pet);
}


}