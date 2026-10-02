package io.gulimall.controller.coupon;
 import java.util.Arrays;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import io.gulimall.entity.coupon.MemberPriceEntity;
import io.gulimall.service.coupon.MemberPriceService;
import io.gulimall.utils.PageUtils;
import io.gulimall.utils.R;
@RestController
@RequestMapping("coupon/memberprice")
public class MemberPriceController {

@Autowired
 private  MemberPriceService memberPriceService;


@RequestMapping("/save")
public R save(MemberPriceEntity memberPrice){
    memberPriceService.save(memberPrice);
    return R.ok();
}


@RequestMapping("/update")
public R update(MemberPriceEntity memberPrice){
    memberPriceService.updateById(memberPrice);
    return R.ok();
}


@RequestMapping("/list")
public R list(Map<String,Object> params){
    PageUtils page = memberPriceService.queryPage(params);
    return R.ok().put("page", page);
}


@RequestMapping("/delete")
public R delete(Long[] ids){
    memberPriceService.removeByIds(Arrays.asList(ids));
    return R.ok();
}


@RequestMapping("/info/{id}")
public R info(Long id){
    MemberPriceEntity memberPrice = memberPriceService.getById(id);
    return R.ok().put("memberPrice", memberPrice);
}


}