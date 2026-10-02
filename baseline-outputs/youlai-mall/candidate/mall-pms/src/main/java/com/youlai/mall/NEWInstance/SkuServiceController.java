package com.youlai.mall.NEWInstance;
 import org.springframework.web.bind.annotation.*;
@RestController
@CrossOrigin
public class SkuServiceController {

 private SkuService skuservice;


@GetMapping
("/unlockStock")
public boolean unlockStock(@RequestParam(name = "orderSn") String orderSn){
  return skuservice.unlockStock(orderSn);
}


@GetMapping
("/getSkuInfo")
public SkuInfoDTO getSkuInfo(@RequestParam(name = "skuId") Long skuId){
  return skuservice.getSkuInfo(skuId);
}


}