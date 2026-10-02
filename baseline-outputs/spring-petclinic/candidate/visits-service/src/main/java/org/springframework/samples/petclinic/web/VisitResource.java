package org.springframework.samples.petclinic.web;
 import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.samples.petclinic.model.Visit;
import org.springframework.samples.petclinic.service.ClinicService;
import org.springframework.samples.petclinic.web.dto.DtoMapper;
import org.springframework.samples.petclinic.web.dto.VisitDetails;
import org.springframework.samples.petclinic.web.dto.Visits;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;
import java.util.List;
import org.springframework.samples.petclinic.Interface.ClinicService;
@RestController
public class VisitResource extends AbstractResourceController{

 private  ClinicService clinicService;

@Autowired
public VisitResource(ClinicService clinicService) {
    this.clinicService = clinicService;
}
@GetMapping({ "/owners/{ownerId}/pets/{petId}/visits", "/api/visit/owners/{ownerId}/pets/{petId}/visits" })
public List<VisitDetails> visits(int petId){
    return DtoMapper.visits(clinicService.findPetById(petId).getVisits()).items;
}


@GetMapping("/api/visit/pets/visits")
public Visits visitsForPets(List<Integer> petIds){
    return DtoMapper.visits(clinicService.findVisitsByPetIds(petIds));
}


@PostMapping({ "/owners/{ownerId}/pets/{petId}/visits", "/api/visit/owners/{ownerId}/pets/{petId}/visits" })
@ResponseStatus(HttpStatus.CREATED)
public VisitDetails create(Visit visit,int petId){
    clinicService.findPetById(petId).addVisit(visit);
    clinicService.saveVisit(visit);
    return DtoMapper.visitDetails(visit);
}


}