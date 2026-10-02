package org.springframework.samples.petclinic.web;
 import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.samples.petclinic.model.Owner;
import org.springframework.samples.petclinic.service.ClinicService;
import org.springframework.samples.petclinic.web.dto.DtoMapper;
import org.springframework.samples.petclinic.web.dto.OwnerDetails;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;
import org.springframework.samples.petclinic.Interface.ClinicService;
import org.springframework.samples.petclinic.DTO.ClinicService;
import org.springframework.samples.petclinic.DTO.ClinicService;
import org.springframework.samples.petclinic.DTO.ClinicService;
@RestController
public class OwnerResource extends AbstractResourceController{

 private  ClinicService clinicService;

@Autowired
public OwnerResource(ClinicService clinicService) {
    this.clinicService = clinicService;
}
public Owner retrieveOwner(int ownerId){
    return this.clinicService.findOwnerById(ownerId);
}


@RequestMapping(value = { "/owners", "/api/customer/owners" }, method = RequestMethod.POST)
@ResponseStatus(HttpStatus.CREATED)
public OwnerDetails createOwner(Owner owner){
    this.clinicService.saveOwner(owner);
    return DtoMapper.ownerDetails(owner);
}


@RequestMapping(value = { "/owners/{ownerId}", "/api/customer/owners/{ownerId}" }, method = RequestMethod.GET)
public OwnerDetails findOwner(int ownerId){
    return DtoMapper.ownerDetails(retrieveOwner(ownerId));
}


@RequestMapping(value = { "/owners/{ownerId}", "/api/customer/owners/{ownerId}" }, method = RequestMethod.PUT)
@ResponseStatus(HttpStatus.NO_CONTENT)
public void updateOwner(int ownerId,Owner ownerRequest){
    Owner ownerModel = retrieveOwner(ownerId);
    // This is done by hand for simplicity purpose. In a real life use-case we should consider using MapStruct.
    ownerModel.setFirstName(ownerRequest.getFirstName());
    ownerModel.setLastName(ownerRequest.getLastName());
    ownerModel.setCity(ownerRequest.getCity());
    ownerModel.setAddress(ownerRequest.getAddress());
    ownerModel.setTelephone(ownerRequest.getTelephone());
    this.clinicService.saveOwner(ownerModel);
}


@GetMapping({ "/owners", "/api/customer/owners" })
public List<OwnerDetails> findAll(){
    return clinicService.findAll().stream().map(DtoMapper::ownerDetails).collect(Collectors.toList());
}


@InitBinder
public void setAllowedFields(WebDataBinder dataBinder){
    dataBinder.setDisallowedFields("id");
}


}