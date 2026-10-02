package io.gulimall.NEWInstance;
 import org.springframework.web.bind.annotation.*;
@RestController
@CrossOrigin
public class AttrServiceController {

 private AttrService attrservice;


@GetMapping
("/getAttrInfo")
public AttrRespVo getAttrInfo(@RequestParam(name = "attrId") Long attrId){
  return attrservice.getAttrInfo(attrId);
}


}