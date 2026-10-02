package io.gulimall.controller.member;
 import java.util.Arrays;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import io.gulimall.entity.member.MemberLevelEntity;
import io.gulimall.service.member.MemberLevelService;
import io.gulimall.utils.PageUtils;
import io.gulimall.utils.R;
@RestController
@RequestMapping("member/memberlevel")
public class MemberLevelController {

@Autowired
 private  MemberLevelService memberLevelService;


@RequestMapping("/save")
public R save(MemberLevelEntity memberLevel){
    memberLevelService.save(memberLevel);
    return R.ok();
}


@RequestMapping("/update")
public R update(MemberLevelEntity memberLevel){
    memberLevelService.updateById(memberLevel);
    return R.ok();
}


@RequestMapping("/list")
public R list(Map<String,Object> params){
    PageUtils page = memberLevelService.queryPage(params);
    return R.ok().put("page", page);
}


@RequestMapping("/delete")
public R delete(Long[] ids){
    memberLevelService.removeByIds(Arrays.asList(ids));
    return R.ok();
}


@RequestMapping("/info/{id}")
public R info(Long id){
    MemberLevelEntity memberLevel = memberLevelService.getById(id);
    return R.ok().put("memberLevel", memberLevel);
}


}