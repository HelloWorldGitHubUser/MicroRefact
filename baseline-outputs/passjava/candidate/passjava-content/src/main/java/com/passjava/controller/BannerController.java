package com.passjava.controller;
 import java.util.Arrays;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.passjava.entity.BannerEntity;
import com.passjava.service.BannerService;
import com.passjava.utils.PageUtils;
import com.passjava.utils.R;
import com.passjava.conDTO.R;
@RestController
@RequestMapping("content/banner")
public class BannerController {

@Autowired
 private  BannerService bannerService;


@RequestMapping("/save")
public R save(BannerEntity banner){
    bannerService.save(banner);
    return R.ok();
}


@RequestMapping("/update")
public R update(BannerEntity banner){
    bannerService.updateById(banner);
    return R.ok();
}


@RequestMapping("/list")
public R list(Map<String,Object> params){
    PageUtils page = bannerService.queryPage(params);
    return R.ok().put("page", page);
}


@RequestMapping("/delete")
public R delete(Long[] ids){
    bannerService.removeByIds(Arrays.asList(ids));
    return R.ok();
}


@RequestMapping("/info/{id}")
public R info(Long id){
    BannerEntity banner = bannerService.getById(id);
    return R.ok().put("banner", banner);
}


}