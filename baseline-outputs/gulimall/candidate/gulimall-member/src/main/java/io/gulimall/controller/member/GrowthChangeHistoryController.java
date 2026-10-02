package io.gulimall.controller.member;
 import java.util.Arrays;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import io.gulimall.entity.member.GrowthChangeHistoryEntity;
import io.gulimall.service.member.GrowthChangeHistoryService;
import io.gulimall.utils.PageUtils;
import io.gulimall.utils.R;
import io.gulimall.DTO.R;
@RestController
@RequestMapping("member/growthchangehistory")
public class GrowthChangeHistoryController {

@Autowired
 private  GrowthChangeHistoryService growthChangeHistoryService;


@RequestMapping("/save")
public R save(GrowthChangeHistoryEntity growthChangeHistory){
    growthChangeHistoryService.save(growthChangeHistory);
    return R.ok();
}


@RequestMapping("/update")
public R update(GrowthChangeHistoryEntity growthChangeHistory){
    growthChangeHistoryService.updateById(growthChangeHistory);
    return R.ok();
}


@RequestMapping("/list")
public R list(Map<String,Object> params){
    PageUtils page = growthChangeHistoryService.queryPage(params);
    return R.ok().put("page", page);
}


@RequestMapping("/delete")
public R delete(Long[] ids){
    growthChangeHistoryService.removeByIds(Arrays.asList(ids));
    return R.ok();
}


@RequestMapping("/info/{id}")
public R info(Long id){
    GrowthChangeHistoryEntity growthChangeHistory = growthChangeHistoryService.getById(id);
    return R.ok().put("growthChangeHistory", growthChangeHistory);
}


}