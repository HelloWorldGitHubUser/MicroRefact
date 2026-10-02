package com.hoangtien2k3.ecommerce.NEWInstance;
 import org.springframework.web.bind.annotation.*;
@RestController
@CrossOrigin
public class UserServiceController {

 private UserService userservice;


@GetMapping
("/findById")
public User findById(@RequestParam(name = "userId") Long userId){
  return userservice.findById(userId);
}


}