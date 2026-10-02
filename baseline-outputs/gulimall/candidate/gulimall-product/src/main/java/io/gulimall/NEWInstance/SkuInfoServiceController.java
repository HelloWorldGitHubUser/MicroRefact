package io.gulimall.NEWInstance;
 import org.springframework.web.bind.annotation.*;
@RestController
@CrossOrigin
public class SkuInfoServiceController {

 private SkuInfoService skuinfoservice;


@GetMapping
("/getById")
public Object getById(@RequestParam(name = "Object") Object Object){
  return skuinfoservice.getById(Object);
}


}