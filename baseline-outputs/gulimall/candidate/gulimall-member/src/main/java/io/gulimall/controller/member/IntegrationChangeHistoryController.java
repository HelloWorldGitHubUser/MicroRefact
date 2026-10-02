package io.gulimall.controller.member;
 import java.util.Arrays;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import io.gulimall.entity.member.IntegrationChangeHistoryEntity;
import io.gulimall.service.member.IntegrationChangeHistoryService;
import io.gulimall.utils.PageUtils;
import io.gulimall.utils.R;
@RestController
@RequestMapping("member/integrationchangehistory")
public class IntegrationChangeHistoryController {

@Autowired
 private  IntegrationChangeHistoryService integrationChangeHistoryService;


@RequestMapping("/save")
public R save(IntegrationChangeHistoryEntity integrationChangeHistory){
    integrationChangeHistoryService.save(integrationChangeHistory);
    return R.ok();
}


@RequestMapping("/update")
public R update(IntegrationChangeHistoryEntity integrationChangeHistory){
    integrationChangeHistoryService.updateById(integrationChangeHistory);
    return R.ok();
}


@RequestMapping("/list")
public R list(Map<String,Object> params){
    PageUtils page = integrationChangeHistoryService.queryPage(params);
    return R.ok().put("page", page);
}


@RequestMapping("/delete")
public R delete(Long[] ids){
    integrationChangeHistoryService.removeByIds(Arrays.asList(ids));
    return R.ok();
}


@RequestMapping("/info/{id}")
public R info(Long id){
    IntegrationChangeHistoryEntity integrationChangeHistory = integrationChangeHistoryService.getById(id);
    return R.ok().put("integrationChangeHistory", integrationChangeHistory);
}


}