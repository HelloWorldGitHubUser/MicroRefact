package io.gulimall.NEWInstance;
 import org.springframework.web.bind.annotation.*;
@RestController
@CrossOrigin
public class SmsComponentController {

 private SmsComponent smscomponent;


@PutMapping
("/sendCode")
public void sendCode(@RequestParam(name = "phone") String phone,@RequestParam(name = "code") String code){
smscomponent.sendCode(phone,code);
}


}