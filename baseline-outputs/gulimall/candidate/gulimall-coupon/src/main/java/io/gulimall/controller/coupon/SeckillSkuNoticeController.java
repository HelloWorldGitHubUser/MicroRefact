package io.gulimall.controller.coupon;
 import java.util.Arrays;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import io.gulimall.entity.coupon.SeckillSkuNoticeEntity;
import io.gulimall.service.coupon.SeckillSkuNoticeService;
import io.gulimall.utils.PageUtils;
import io.gulimall.utils.R;
@RestController
@RequestMapping("coupon/seckillskunotice")
public class SeckillSkuNoticeController {

@Autowired
 private  SeckillSkuNoticeService seckillSkuNoticeService;


@RequestMapping("/save")
public R save(SeckillSkuNoticeEntity seckillSkuNotice){
    seckillSkuNoticeService.save(seckillSkuNotice);
    return R.ok();
}


@RequestMapping("/update")
public R update(SeckillSkuNoticeEntity seckillSkuNotice){
    seckillSkuNoticeService.updateById(seckillSkuNotice);
    return R.ok();
}


@RequestMapping("/list")
public R list(Map<String,Object> params){
    PageUtils page = seckillSkuNoticeService.queryPage(params);
    return R.ok().put("page", page);
}


@RequestMapping("/delete")
public R delete(Long[] ids){
    seckillSkuNoticeService.removeByIds(Arrays.asList(ids));
    return R.ok();
}


@RequestMapping("/info/{id}")
public R info(Long id){
    SeckillSkuNoticeEntity seckillSkuNotice = seckillSkuNoticeService.getById(id);
    return R.ok().put("seckillSkuNotice", seckillSkuNotice);
}


}