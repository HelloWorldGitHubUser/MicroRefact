package io.gulimall.NEWInstance;
 import org.springframework.web.bind.annotation.*;
@RestController
@CrossOrigin
public class SkuSaleAttrValueServiceController {

 private SkuSaleAttrValueService skusaleattrvalueservice;


@GetMapping
("/getSkuSaleAttrValuesAsString")
public List<String> getSkuSaleAttrValuesAsString(@RequestParam(name = "skuId") Long skuId){
  return skusaleattrvalueservice.getSkuSaleAttrValuesAsString(skuId);
}


}