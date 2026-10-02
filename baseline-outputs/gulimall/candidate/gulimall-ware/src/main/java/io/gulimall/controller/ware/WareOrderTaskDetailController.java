package io.gulimall.controller.ware;
 import java.util.Arrays;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import io.gulimall.entity.ware.WareOrderTaskDetailEntity;
import io.gulimall.service.ware.WareOrderTaskDetailService;
import io.gulimall.utils.PageUtils;
import io.gulimall.utils.R;
@RestController
@RequestMapping("ware/wareordertaskdetail")
public class WareOrderTaskDetailController {

@Autowired
 private  WareOrderTaskDetailService wareOrderTaskDetailService;


@RequestMapping("/save")
public R save(WareOrderTaskDetailEntity wareOrderTaskDetail){
    wareOrderTaskDetailService.save(wareOrderTaskDetail);
    return R.ok();
}


@RequestMapping("/update")
public R update(WareOrderTaskDetailEntity wareOrderTaskDetail){
    wareOrderTaskDetailService.updateById(wareOrderTaskDetail);
    return R.ok();
}


@RequestMapping("/list")
public R list(Map<String,Object> params){
    PageUtils page = wareOrderTaskDetailService.queryPage(params);
    return R.ok().put("page", page);
}


@RequestMapping("/delete")
public R delete(Long[] ids){
    wareOrderTaskDetailService.removeByIds(Arrays.asList(ids));
    return R.ok();
}


@RequestMapping("/info/{id}")
public R info(Long id){
    WareOrderTaskDetailEntity wareOrderTaskDetail = wareOrderTaskDetailService.getById(id);
    return R.ok().put("wareOrderTaskDetail", wareOrderTaskDetail);
}


}