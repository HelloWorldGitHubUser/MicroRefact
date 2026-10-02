package io.gulimall.NEWInstance;
 import org.springframework.web.bind.annotation.*;
@RestController
@CrossOrigin
public class MemberServiceController {

 private MemberService memberservice;


@GetMapping
("/login")
public MemberEntity login(@RequestParam(name = "socialUser") SocialUser socialUser){
  return memberservice.login(socialUser);
}


@PutMapping
("/register")
public void register(@RequestParam(name = "registerVo") MemberRegisterVo registerVo){
memberservice.register(registerVo);
}


}