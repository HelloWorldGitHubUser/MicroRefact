package com.youlai.mall.NEWInstance;
 import org.springframework.web.bind.annotation.*;
@RestController
@CrossOrigin
public class SysUserServiceController {

 private SysUserService sysuserservice;


@GetMapping
("/getUserAuthInfo")
public UserAuthInfo getUserAuthInfo(@RequestParam(name = "username") String username){
  return sysuserservice.getUserAuthInfo(username);
}


}