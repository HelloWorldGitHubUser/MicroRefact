package io.gulimall.Interface;
 import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import io.gulimall.Interface.CouponService;
public class CouponServiceImpl implements CouponService{

@Autowired
 private RestTemplate restTemplate;

  String url = "http://2";


public List<CouponEntity> listMemberCoupons(){
  UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url.concat("/listMemberCoupons"))
;  List<CouponEntity> aux = restTemplate.getForObject(builder.toUriString(), List<CouponEntity>.class);

 return aux;
}


}