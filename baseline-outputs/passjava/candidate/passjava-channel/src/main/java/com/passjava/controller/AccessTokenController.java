package com.passjava.controller;
 import java.util.Arrays;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.passjava.entity.AccessTokenEntity;
import com.passjava.service.AccessTokenService;
import com.passjava.utils.PageUtils;
import com.passjava.utils.R;
import com.passjava.conDTO.R;
@RestController
@RequestMapping("channel/accesstoken")
public class AccessTokenController {

@Autowired
 private  AccessTokenService accessTokenService;


@RequestMapping("/save")
public R save(AccessTokenEntity accessToken){
    accessTokenService.save(accessToken);
    return R.ok();
}


@RequestMapping("/update")
public R update(AccessTokenEntity accessToken){
    accessTokenService.updateById(accessToken);
    return R.ok();
}


@RequestMapping("/list")
public R list(Map<String,Object> params){
    PageUtils page = accessTokenService.queryPage(params);
    return R.ok().put("page", page);
}


@RequestMapping("/delete")
public R delete(Long[] ids){
    accessTokenService.removeByIds(Arrays.asList(ids));
    return R.ok();
}


@RequestMapping("/info/{id}")
public R info(Long id){
    AccessTokenEntity accessToken = accessTokenService.getById(id);
    return R.ok().put("accessToken", accessToken);
}


}