package io.gulimall.controller.coupon;
 import java.util.Arrays;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import io.gulimall.entity.coupon.HomeAdvEntity;
import io.gulimall.service.coupon.HomeAdvService;
import io.gulimall.utils.PageUtils;
import io.gulimall.utils.R;
@RestController
@RequestMapping("coupon/homeadv")
public class HomeAdvController {

@Autowired
 private  HomeAdvService homeAdvService;


@RequestMapping("/save")
public R save(HomeAdvEntity homeAdv){
    homeAdvService.save(homeAdv);
    return R.ok();
}


@RequestMapping("/update")
public R update(HomeAdvEntity homeAdv){
    homeAdvService.updateById(homeAdv);
    return R.ok();
}


@RequestMapping("/list")
public R list(Map<String,Object> params){
    PageUtils page = homeAdvService.queryPage(params);
    return R.ok().put("page", page);
}


@RequestMapping("/delete")
public R delete(Long[] ids){
    homeAdvService.removeByIds(Arrays.asList(ids));
    return R.ok();
}


@RequestMapping("/info/{id}")
public R info(Long id){
    HomeAdvEntity homeAdv = homeAdvService.getById(id);
    return R.ok().put("homeAdv", homeAdv);
}


}