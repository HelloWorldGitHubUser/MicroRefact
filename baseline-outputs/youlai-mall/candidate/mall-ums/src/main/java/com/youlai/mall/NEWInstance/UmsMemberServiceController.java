package com.youlai.mall.NEWInstance;
 import org.springframework.web.bind.annotation.*;
@RestController
@CrossOrigin
public class UmsMemberServiceController {

 private UmsMemberService umsmemberservice;


@GetMapping
("/loadUserByMobile")
public MemberAuthDTO loadUserByMobile(@RequestParam(name = "mobile") String mobile){
  return umsmemberservice.loadUserByMobile(mobile);
}


@GetMapping
("/loadUserByOpenId")
public MemberAuthDTO loadUserByOpenId(@RequestParam(name = "openid") String openid){
  return umsmemberservice.loadUserByOpenId(openid);
}


@GetMapping
("/registerMember")
public Long registerMember(@RequestParam(name = "dto") MemberRegisterDto dto){
  return umsmemberservice.registerMember(dto);
}


}