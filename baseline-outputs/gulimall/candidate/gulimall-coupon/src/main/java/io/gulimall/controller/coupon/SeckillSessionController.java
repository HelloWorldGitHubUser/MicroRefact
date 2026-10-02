package io.gulimall.controller.coupon;
 import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import io.gulimall.entity.coupon.SeckillSessionEntity;
import io.gulimall.service.coupon.SeckillSessionService;
import io.gulimall.utils.PageUtils;
import io.gulimall.utils.R;
@RestController
@RequestMapping("coupon/seckillsession")
public class SeckillSessionController {

@Autowired
 private  SeckillSessionService seckillSessionService;


@RequestMapping("/getSeckillSessionsIn3Days")
public R getSeckillSessionsIn3Days(){
    List<SeckillSessionEntity> seckillSessionEntities = seckillSessionService.getSeckillSessionsIn3Days();
    return R.ok().setData(seckillSessionEntities);
}


@RequestMapping("/save")
public R save(SeckillSessionEntity seckillSession){
    seckillSessionService.save(seckillSession);
    return R.ok();
}


@RequestMapping("/update")
public R update(SeckillSessionEntity seckillSession){
    seckillSessionService.updateById(seckillSession);
    return R.ok();
}


@RequestMapping("/list")
public R list(Map<String,Object> params){
    PageUtils page = seckillSessionService.queryPage(params);
    return R.ok().put("page", page);
}


@RequestMapping("/delete")
public R delete(Long[] ids){
    seckillSessionService.removeByIds(Arrays.asList(ids));
    return R.ok();
}


@RequestMapping("/info/{id}")
public R info(Long id){
    SeckillSessionEntity seckillSession = seckillSessionService.getById(id);
    return R.ok().put("seckillSession", seckillSession);
}


}