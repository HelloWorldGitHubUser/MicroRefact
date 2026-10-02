package com.hoangtien2k3.ecommerce.NEWInstance;
 import org.springframework.web.bind.annotation.*;
@RestController
@CrossOrigin
public class ProductServiceController {

 private ProductService productservice;


@GetMapping
("/findById")
public ProductDto findById(@RequestParam(name = "productId") Integer productId){
  return productservice.findById(productId);
}


}