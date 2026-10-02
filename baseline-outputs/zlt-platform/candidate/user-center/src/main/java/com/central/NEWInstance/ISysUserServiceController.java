package com.central.NEWInstance;
 import org.springframework.web.bind.annotation.*;
@RestController
@CrossOrigin
public class ISysUserServiceController {

 private ISysUserService isysuserservice;


@GetMapping
("/findByUsername")
public SysUser findByUsername(@RequestParam(name = "username") String username){
  return isysuserservice.findByUsername(username);
}


@GetMapping
("/findRolesByUserId")
public List<SysRole> findRolesByUserId(@RequestParam(name = "userId") Long userId){
  return isysuserservice.findRolesByUserId(userId);
}


@GetMapping
("/getById")
public Object getById(@RequestParam(name = "Object") Object Object){
  return isysuserservice.getById(Object);
}


@PutMapping
("/setUserPermission")
public void setUserPermission(@RequestParam(name = "sysUser") SysUser sysUser){
isysuserservice.setUserPermission(sysUser);
}


}