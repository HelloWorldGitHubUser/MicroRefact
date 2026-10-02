package io.gulimall.controller.ware;
 import java.util.Arrays;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import io.gulimall.entity.ware.WareOrderTaskEntity;
import io.gulimall.service.ware.WareOrderTaskService;
import io.gulimall.utils.PageUtils;
import io.gulimall.utils.R;
@RestController
@RequestMapping("ware/wareordertask")
public class WareOrderTaskController {

@Autowired
 private  WareOrderTaskService wareOrderTaskService;


@RequestMapping("/save")
public R save(WareOrderTaskEntity wareOrderTask){
    wareOrderTaskService.save(wareOrderTask);
    return R.ok();
}


@RequestMapping("/update")
public R update(WareOrderTaskEntity wareOrderTask){
    wareOrderTaskService.updateById(wareOrderTask);
    return R.ok();
}


@RequestMapping("/list")
public R list(Map<String,Object> params){
    PageUtils page = wareOrderTaskService.queryPage(params);
    return R.ok().put("page", page);
}


@RequestMapping("/delete")
public R delete(Long[] ids){
    wareOrderTaskService.removeByIds(Arrays.asList(ids));
    return R.ok();
}


@RequestMapping("/info/{id}")
public R info(Long id){
    WareOrderTaskEntity wareOrderTask = wareOrderTaskService.getById(id);
    return R.ok().put("wareOrderTask", wareOrderTask);
}


}