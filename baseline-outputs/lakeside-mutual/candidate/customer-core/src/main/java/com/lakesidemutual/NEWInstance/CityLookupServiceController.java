package com.lakesidemutual.NEWInstance;
 import org.springframework.web.bind.annotation.*;
@RestController
@CrossOrigin
public class CityLookupServiceController {

 private CityLookupService citylookupservice;


@GetMapping
("/getCitiesForPostalCode")
public List<String> getCitiesForPostalCode(@RequestParam(name = "postalCode") String postalCode){
  return citylookupservice.getCitiesForPostalCode(postalCode);
}


}