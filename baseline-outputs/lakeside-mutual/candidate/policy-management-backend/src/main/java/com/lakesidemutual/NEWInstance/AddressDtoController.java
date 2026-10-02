package com.lakesidemutual.NEWInstance;
 import org.springframework.web.bind.annotation.*;
@RestController
@CrossOrigin
public class AddressDtoController {

 private AddressDto addressdto;

 private AddressDto addressdto;


@PutMapping
("/setPostalCode")
public void setPostalCode(@RequestParam(name = "postalCode") String postalCode){
addressdto.setPostalCode(postalCode);
}


@PutMapping
("/setCity")
public void setCity(@RequestParam(name = "city") String city){
addressdto.setCity(city);
}


}