package io.gulimall.NEWInstance;
 import org.springframework.web.bind.annotation.*;
@RestController
@CrossOrigin
public class CouponServiceController {

 private CouponService couponservice;


@GetMapping
("/listMemberCoupons")
public List<CouponEntity> listMemberCoupons(){
  return couponservice.listMemberCoupons();
}


}