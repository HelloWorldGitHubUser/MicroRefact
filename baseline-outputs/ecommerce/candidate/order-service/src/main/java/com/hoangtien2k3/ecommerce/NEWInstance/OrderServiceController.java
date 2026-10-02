package com.hoangtien2k3.ecommerce.NEWInstance;
 import org.springframework.web.bind.annotation.*;
@RestController
@CrossOrigin
public class OrderServiceController {

 private OrderService orderservice;


@GetMapping
("/findById")
public OrderDto findById(@RequestParam(name = "orderId") Integer orderId){
  return orderservice.findById(orderId);
}


}