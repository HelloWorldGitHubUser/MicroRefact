package io.gulimall.controller.coupon;
 import java.util.Arrays;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import io.gulimall.entity.coupon.HomeSubjectSpuEntity;
import io.gulimall.service.coupon.HomeSubjectSpuService;
import io.gulimall.utils.PageUtils;
import io.gulimall.utils.R;
@RestController
@RequestMapping("coupon/homesubjectspu")
public class HomeSubjectSpuController {

@Autowired
 private  HomeSubjectSpuService homeSubjectSpuService;


@RequestMapping("/save")
public R save(HomeSubjectSpuEntity homeSubjectSpu){
    homeSubjectSpuService.save(homeSubjectSpu);
    return R.ok();
}


@RequestMapping("/update")
public R update(HomeSubjectSpuEntity homeSubjectSpu){
    homeSubjectSpuService.updateById(homeSubjectSpu);
    return R.ok();
}


@RequestMapping("/list")
public R list(Map<String,Object> params){
    PageUtils page = homeSubjectSpuService.queryPage(params);
    return R.ok().put("page", page);
}


@RequestMapping("/delete")
public R delete(Long[] ids){
    homeSubjectSpuService.removeByIds(Arrays.asList(ids));
    return R.ok();
}


@RequestMapping("/info/{id}")
public R info(Long id){
    HomeSubjectSpuEntity homeSubjectSpu = homeSubjectSpuService.getById(id);
    return R.ok().put("homeSubjectSpu", homeSubjectSpu);
}


}