package com.passjava.controller;
 import com.passjava.utils.PageUtils;
import com.passjava.utils.R;
import com.passjava.entity.MemberEntity;
import com.passjava.service.MemberService;
import com.passjava.service.StudyTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation;
import java.util.Arrays;
import java.util.Map;
import com.passjava.conInterface.StudyTimeService;
@RestController
@RequestMapping("member/member")
public class MemberController {

@Autowired
 private  MemberService memberService;

@Autowired
 private  StudyTimeService studyTimeService;


@RequestMapping("/createMember")
public R createMember(MemberEntity member) throws Exception{
    memberService.sendCoupon(1);
    return R.ok();
}


@RequestMapping("/studytime/list/test/{id}")
public R getMemberStudyTimeListTest(Long id){
    MemberEntity memberEntity = new MemberEntity();
    memberEntity.setId(id);
    memberEntity.setNickname("悟空聊架构");
    R memberStudyTimeList = studyTimeService.getMemberStudyTimeListTest(id);
    return R.ok().put("member", memberEntity).put("studytime", memberStudyTimeList.get("studytime"));
}


@RequestMapping("/save")
public R save(MemberEntity member){
    memberService.save(member);
    return R.ok();
}


@RequestMapping("/update")
public R update(MemberEntity member){
    memberService.updateById(member);
    return R.ok();
}


@RequestMapping("/list")
public R list(Map<String,Object> params){
    PageUtils page = memberService.queryPage(params);
    return R.ok().put("page", page);
}


@RequestMapping("/delete")
public R delete(Long[] ids){
    memberService.removeByIds(Arrays.asList(ids));
    return R.ok();
}


@RequestMapping("/info/{id}")
public R info(Long id){
    MemberEntity member = memberService.getById(id);
    return R.ok().put("member", member);
}


}