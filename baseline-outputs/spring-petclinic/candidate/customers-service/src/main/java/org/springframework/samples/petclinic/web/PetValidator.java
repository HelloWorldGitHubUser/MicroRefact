package org.springframework.samples.petclinic.web;
 import org.springframework.samples.petclinic.model.Pet;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
public class PetValidator {

 private  String REQUIRED;


public void validate(Pet pet,Errors errors){
    String name = pet.getName();
    // name validation
    if (!StringUtils.hasLength(name)) {
        errors.rejectValue("name", REQUIRED, REQUIRED);
    } else if (pet.isNew() && pet.getOwner().getPet(name, true) != null) {
        errors.rejectValue("name", "duplicate", "already exists");
    }
    // type validation
    if (pet.isNew() && pet.getType() == null) {
        errors.rejectValue("type", REQUIRED, REQUIRED);
    }
    // birth date validation
    if (pet.getBirthDate() == null) {
        errors.rejectValue("birthDate", REQUIRED, REQUIRED);
    }
}


}