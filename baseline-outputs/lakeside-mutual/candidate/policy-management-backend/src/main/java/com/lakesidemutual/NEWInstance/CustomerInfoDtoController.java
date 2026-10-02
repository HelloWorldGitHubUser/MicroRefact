package com.lakesidemutual.NEWInstance;
 import org.springframework.web.bind.annotation.*;
@RestController
@CrossOrigin
public class CustomerInfoDtoController {

 private CustomerInfoDto customerinfodto;

 private CustomerInfoDto customerinfodto;


@PutMapping
("/setFirstname")
public void setFirstname(@RequestParam(name = "firstname") String firstname){
customerinfodto.setFirstname(firstname);
}


@PutMapping
("/setLastname")
public void setLastname(@RequestParam(name = "lastname") String lastname){
customerinfodto.setLastname(lastname);
}


@PutMapping
("/setContactAddress")
public void setContactAddress(@RequestParam(name = "contactAddress") AddressDto contactAddress){
customerinfodto.setContactAddress(contactAddress);
}


@PutMapping
("/setBillingAddress")
public void setBillingAddress(@RequestParam(name = "billingAddress") AddressDto billingAddress){
customerinfodto.setBillingAddress(billingAddress);
}


}