package io.gulimall.controller.ware;
 import java.util.Arrays;
import java.util.Map;
import io.gulimall.vo.FareVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import io.gulimall.entity.ware.WareInfoEntity;
import io.gulimall.service.ware.WareInfoService;
import io.gulimall.utils.PageUtils;
import io.gulimall.utils.R;
@RestController
@RequestMapping("ware/wareinfo")
public class WareInfoController {

@Autowired
 private  WareInfoService wareInfoService;


@RequestMapping("/save")
public R save(WareInfoEntity wareInfo){
    wareInfoService.save(wareInfo);
    return R.ok();
}


@RequestMapping("/update")
public R update(WareInfoEntity wareInfo){
    wareInfoService.updateById(wareInfo);
    return R.ok();
}


@RequestMapping("/fare/{addrId}")
public FareVo getFare(Long addrId){
    return wareInfoService.getFare(addrId);
}


@RequestMapping("/list")
public R list(Map<String,Object> params){
    PageUtils page = wareInfoService.queryPage(params);
    return R.ok().put("page", page);
}


@RequestMapping("/delete")
public R delete(Long[] ids){
    wareInfoService.removeByIds(Arrays.asList(ids));
    return R.ok();
}


@RequestMapping("/info/{id}")
public R info(Long id){
    WareInfoEntity wareInfo = wareInfoService.getById(id);
    return R.ok().put("wareInfo", wareInfo);
}


}