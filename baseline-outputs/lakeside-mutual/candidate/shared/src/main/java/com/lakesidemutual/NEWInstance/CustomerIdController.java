package com.lakesidemutual.NEWInstance;
 import org.springframework.web.bind.annotation.*;
@RestController
@CrossOrigin
public class CustomerIdController {

 private CustomerId customerid;


@GetMapping
("/toString")
public String toString(){
  return customerid.toString();
}


@GetMapping
("/equals")
public boolean equals(@RequestParam(name = "obj") Object obj){
  return customerid.equals(obj);
}


}