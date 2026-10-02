package io.gulimall.NEWInstance;
 import org.springframework.web.bind.annotation.*;
@RestController
@CrossOrigin
public class CartServiceController {

 private CartService cartservice;


@GetMapping
("/getCart")
public CartVo getCart(){
  return cartservice.getCart();
}


}