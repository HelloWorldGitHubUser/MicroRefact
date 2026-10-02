package com.passjava.controller;
 import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.passjava.entity.TypeEntity;
import com.passjava.service.ITypeService;
import com.passjava.utils.PageUtils;
import com.passjava.utils.R;
@RestController
@RequestMapping("question/type")
public class TypeController {

@Autowired
 private  ITypeService typeService;


@GetMapping("/all-with-lock")
public R getAllWithLock(){
    List<TypeEntity> list = typeService.getTypeEntityListWithLock();
    return R.ok().put("data", list);
}


@GetMapping("/all")
public R getAll(){
    List<TypeEntity> list = typeService.getTypeEntityList();
    return R.ok().put("data", list);
}


@RequestMapping("/save")
public R save(TypeEntity type){
    typeService.save(type);
    return R.ok();
}


@RequestMapping("/update")
public R update(TypeEntity type){
    typeService.updateById(type);
    return R.ok();
}


@RequestMapping("/list")
public R list(Map<String,Object> params){
    PageUtils page = typeService.queryPage(params);
    return R.ok().put("page", page);
}


@RequestMapping("/delete")
public R delete(Long[] ids){
    typeService.removeByIds(Arrays.asList(ids));
    return R.ok();
}


@RequestMapping("/info/{id}")
public R info(Long id){
    TypeEntity type = typeService.getById(id);
    return R.ok().put("type", type);
}


}