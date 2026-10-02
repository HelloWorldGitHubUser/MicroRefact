package io.gulimall.NEWInstance;
 import org.springframework.web.bind.annotation.*;
@RestController
@CrossOrigin
public class OrderServiceController {

 private OrderService orderservice;


@PutMapping
("/createSeckillOrder")
public void createSeckillOrder(@RequestParam(name = "orderTo") SeckillOrderTo orderTo){
orderservice.createSeckillOrder(orderTo);
}


}