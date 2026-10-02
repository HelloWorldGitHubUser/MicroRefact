package com.youlai.mall.NEWInstance;
 import org.springframework.web.bind.annotation.*;
@RestController
@CrossOrigin
public class AliyunSmsPropertiesController {

 private AliyunSmsProperties aliyunsmsproperties;


@GetMapping
("/getTemplateCodes")
public Object getTemplateCodes(@RequestParam(name = "Object") Object Object){
  return aliyunsmsproperties.getTemplateCodes(Object);
}


}