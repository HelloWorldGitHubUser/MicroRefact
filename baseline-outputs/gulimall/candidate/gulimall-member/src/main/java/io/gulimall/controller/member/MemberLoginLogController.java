package io.gulimall.controller.member;
 import java.util.Arrays;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import io.gulimall.entity.member.MemberLoginLogEntity;
import io.gulimall.service.member.MemberLoginLogService;
import io.gulimall.utils.PageUtils;
import io.gulimall.utils.R;
@RestController
@RequestMapping("member/memberloginlog")
public class MemberLoginLogController {

@Autowired
 private  MemberLoginLogService memberLoginLogService;


@RequestMapping("/save")
public R save(MemberLoginLogEntity memberLoginLog){
    memberLoginLogService.save(memberLoginLog);
    return R.ok();
}


@RequestMapping("/update")
public R update(MemberLoginLogEntity memberLoginLog){
    memberLoginLogService.updateById(memberLoginLog);
    return R.ok();
}


@RequestMapping("/list")
public R list(Map<String,Object> params){
    PageUtils page = memberLoginLogService.queryPage(params);
    return R.ok().put("page", page);
}


@RequestMapping("/delete")
public R delete(Long[] ids){
    memberLoginLogService.removeByIds(Arrays.asList(ids));
    return R.ok();
}


@RequestMapping("/info/{id}")
public R info(Long id){
    MemberLoginLogEntity memberLoginLog = memberLoginLogService.getById(id);
    return R.ok().put("memberLoginLog", memberLoginLog);
}


}