package io.gulimall.controller.member;
 import java.util.Arrays;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import io.gulimall.entity.member.MemberStatisticsInfoEntity;
import io.gulimall.service.member.MemberStatisticsInfoService;
import io.gulimall.utils.PageUtils;
import io.gulimall.utils.R;
@RestController
@RequestMapping("member/memberstatisticsinfo")
public class MemberStatisticsInfoController {

@Autowired
 private  MemberStatisticsInfoService memberStatisticsInfoService;


@RequestMapping("/save")
public R save(MemberStatisticsInfoEntity memberStatisticsInfo){
    memberStatisticsInfoService.save(memberStatisticsInfo);
    return R.ok();
}


@RequestMapping("/update")
public R update(MemberStatisticsInfoEntity memberStatisticsInfo){
    memberStatisticsInfoService.updateById(memberStatisticsInfo);
    return R.ok();
}


@RequestMapping("/list")
public R list(Map<String,Object> params){
    PageUtils page = memberStatisticsInfoService.queryPage(params);
    return R.ok().put("page", page);
}


@RequestMapping("/delete")
public R delete(Long[] ids){
    memberStatisticsInfoService.removeByIds(Arrays.asList(ids));
    return R.ok();
}


@RequestMapping("/info/{id}")
public R info(Long id){
    MemberStatisticsInfoEntity memberStatisticsInfo = memberStatisticsInfoService.getById(id);
    return R.ok().put("memberStatisticsInfo", memberStatisticsInfo);
}


}