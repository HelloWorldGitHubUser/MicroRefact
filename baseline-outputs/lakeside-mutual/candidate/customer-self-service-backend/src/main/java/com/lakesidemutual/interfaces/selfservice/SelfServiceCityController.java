package com.lakesidemutual.interfaces.selfservice;
 import java.util.List;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.lakesidemutual.domain.customer.CityLookupService;
import com.lakesidemutual.interfaces.dtos.city.CitiesResponseDto;
import com.lakesidemutual.Interface.CityLookupService;
@RestController
@RequestMapping("/api/selfservice/cities")
public class SelfServiceCityController {

@Autowired
 private  CityLookupService cityLookupService;


@Operation(summary = "Get the cities for a particular postal code.")
@GetMapping(value = "/{postalCode}")
public ResponseEntity<CitiesResponseDto> getCitiesForPostalCode(String postalCode){
    List<String> cities = cityLookupService.getCitiesForPostalCode(postalCode);
    CitiesResponseDto response = new CitiesResponseDto(cities);
    return ResponseEntity.ok(response);
}


}