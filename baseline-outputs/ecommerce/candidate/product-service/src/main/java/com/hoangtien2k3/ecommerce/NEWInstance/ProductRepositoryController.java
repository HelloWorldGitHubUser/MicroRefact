package com.hoangtien2k3.ecommerce.NEWInstance;
 import org.springframework.web.bind.annotation.*;
@RestController
@CrossOrigin
public class ProductRepositoryController {

 private ProductRepository productrepository;


@GetMapping
("/findById")
public Object findById(@RequestParam(name = "Object") Object Object){
  return productrepository.findById(Object);
}


}