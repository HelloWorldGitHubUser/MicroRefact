package com.youlai.mall.NEWInstance;
 import org.springframework.web.bind.annotation.*;
@RestController
@CrossOrigin
public class SmsServiceController {

 private SmsService smsservice;


@GetMapping
("/sendSms")
public boolean sendSms(@RequestParam(name = "mobile") String mobile,@RequestParam(name = "templateCode") String templateCode,@RequestParam(name = "templateParam") String templateParam){
  return smsservice.sendSms(mobile,templateCode,templateParam);
}


}