package io.gulimall.controller.product;
 import java.util.Arrays;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import io.gulimall.entity.product.AttrAttrgroupRelationEntity;
import io.gulimall.service.product.AttrAttrgroupRelationService;
import io.gulimall.utils.PageUtils;
import io.gulimall.utils.R;
import io.gulimall.DTO.R;
@RestController
@RequestMapping("product/attrattrgrouprelation")
public class AttrAttrgroupRelationController {

@Autowired
 private  AttrAttrgroupRelationService attrAttrgroupRelationService;


@RequestMapping("/save")
public R save(AttrAttrgroupRelationEntity attrAttrgroupRelation){
    attrAttrgroupRelationService.save(attrAttrgroupRelation);
    return R.ok();
}


@RequestMapping("/update")
public R update(AttrAttrgroupRelationEntity attrAttrgroupRelation){
    attrAttrgroupRelationService.updateById(attrAttrgroupRelation);
    return R.ok();
}


@RequestMapping("/list")
public R list(Map<String,Object> params){
    PageUtils page = attrAttrgroupRelationService.queryPage(params);
    return R.ok().put("page", page);
}


@RequestMapping("/delete")
public R delete(Long[] ids){
    attrAttrgroupRelationService.removeByIds(Arrays.asList(ids));
    return R.ok();
}


@RequestMapping("/info/{id}")
public R info(Long id){
    AttrAttrgroupRelationEntity attrAttrgroupRelation = attrAttrgroupRelationService.getById(id);
    return R.ok().put("attrAttrgroupRelation", attrAttrgroupRelation);
}


}