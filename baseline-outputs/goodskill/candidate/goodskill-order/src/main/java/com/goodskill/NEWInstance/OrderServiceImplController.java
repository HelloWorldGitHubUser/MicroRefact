package com.goodskill.NEWInstance;
 import org.springframework.web.bind.annotation.*;
@RestController
@CrossOrigin
public class OrderServiceImplController {

 private OrderServiceImpl orderserviceimpl;


@GetMapping
("/count")
public Long count(@RequestParam(name = "seckillId") long seckillId){
  return orderserviceimpl.count(seckillId);
}


@GetMapping
("/saveRecord")
public String saveRecord(@RequestParam(name = "orderDTO") OrderDTO orderDTO){
  return orderserviceimpl.saveRecord(orderDTO);
}


@GetMapping
("/deleteRecord")
public Boolean deleteRecord(@RequestParam(name = "seckillId") long seckillId){
  return orderserviceimpl.deleteRecord(seckillId);
}


}