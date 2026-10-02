package io.gulimall.controller.product;
 import java.util.Arrays;
import java.util.List;
import java.util.Map;
import io.gulimall.entity.product.AttrAttrgroupRelationEntity;
import io.gulimall.entity.product.AttrEntity;
import io.gulimall.service.product.AttrService;
import io.gulimall.service.product.CategoryService;
import io.gulimall.vo.product.AttrGroupWithAttrVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation;
import io.gulimall.entity.product.AttrGroupEntity;
import io.gulimall.service.product.AttrGroupService;
import io.gulimall.utils.PageUtils;
import io.gulimall.utils.R;
@RestController
@RequestMapping("product/attrgroup")
public class AttrGroupController {

@Autowired
 private  AttrGroupService attrGroupService;

@Autowired
 private  CategoryService categoryService;

@Autowired
 private  AttrService attrService;


@RequestMapping("/{attrgroupId}/attr/relation")
public R attrRelation(Long attrgroupId){
    List<AttrEntity> attrEntities = attrService.getRelationAttr(attrgroupId);
    return R.ok().put("data", attrEntities);
}


@GetMapping("/{catelogId}/withattr")
public R getAttrGroupWithAttrByCatelogId(Long catId){
    List<AttrGroupWithAttrVo> groupWithAttrVos = attrGroupService.getAttrGroupWithAttrByCatelogId(catId);
    return R.ok().put("data", groupWithAttrVos);
}


@PostMapping("/attr/relation")
public R saveBatch(List<AttrAttrgroupRelationEntity> relationEntities){
    attrService.saveRelationBatch(relationEntities);
    return R.ok();
}


@GetMapping("/{attrgroupId}/noattr/relation")
public R attrNoRelation(Long attrgroupId,Map<String,Object> params){
    PageUtils page = attrService.getNoRelationAttr(attrgroupId, params);
    return R.ok().put("page", page);
}


@RequestMapping("/save")
public R save(AttrGroupEntity attrGroup){
    attrGroupService.save(attrGroup);
    return R.ok();
}


@RequestMapping("/update")
public R update(AttrGroupEntity attrGroup){
    attrGroupService.updateById(attrGroup);
    return R.ok();
}


@RequestMapping("list/{catelogId}")
public R list(Map<String,Object> params,long catelogId){
    // PageUtils page = attrGroupService.queryPage(params);
    PageUtils page = attrGroupService.queryPage(params, catelogId);
    return R.ok().put("page", page);
}


@RequestMapping("/delete")
public R delete(Long[] attrGroupIds){
    attrGroupService.removeByIds(Arrays.asList(attrGroupIds));
    return R.ok();
}


@RequestMapping("/info/{attrGroupId}")
public R info(Long attrGroupId){
    AttrGroupEntity attrGroup = attrGroupService.getById(attrGroupId);
    Long[] catelogPath = categoryService.findCatelogPathById(attrGroup.getCatelogId());
    attrGroup.setCatelogPath(catelogPath);
    return R.ok().put("attrGroup", attrGroup);
}


}