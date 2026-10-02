package org.springframework.samples.petclinic.web;
 import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.service.ClinicService;
import org.springframework.samples.petclinic.web.dto.DtoMapper;
import org.springframework.samples.petclinic.web.dto.VetDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.samples.petclinic.Interface.ClinicService;
import org.springframework.samples.petclinic.DTO.ClinicService;
@RestController
public class VetResource extends AbstractResourceController{

 private  ClinicService clinicService;

@Autowired
public VetResource(ClinicService clinicService) {
    this.clinicService = clinicService;
}
@GetMapping({ "/vets", "/api/vet/vets" })
public List<VetDetails> showResourcesVetList(){
    return this.clinicService.findVets().stream().map(DtoMapper::vetDetails).collect(Collectors.toList());
}


}