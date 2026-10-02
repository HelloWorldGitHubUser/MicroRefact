package com.passjava.controller;
 import java.util.Arrays;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.passjava.entity.ViewLogEntity;
import com.passjava.service.ViewLogService;
import com.passjava.utils.PageUtils;
import com.passjava.utils.R;
@RestController
@RequestMapping("study/viewlog")
public class ViewLogController {

@Autowired
 private  ViewLogService viewLogService;


@RequestMapping("/save")
public R save(ViewLogEntity viewLog){
    viewLogService.save(viewLog);
    return R.ok();
}


@RequestMapping("/update")
public R update(ViewLogEntity viewLog){
    viewLogService.updateById(viewLog);
    return R.ok();
}


@RequestMapping("/list")
public R list(Map<String,Object> params){
    PageUtils page = viewLogService.queryPage(params);
    return R.ok().put("page", page);
}


@RequestMapping("/delete")
public R delete(Long[] ids){
    viewLogService.removeByIds(Arrays.asList(ids));
    return R.ok();
}


@RequestMapping("/info/{id}")
public R info(Long id){
    ViewLogEntity viewLog = viewLogService.getById(id);
    return R.ok().put("viewLog", viewLog);
}


}