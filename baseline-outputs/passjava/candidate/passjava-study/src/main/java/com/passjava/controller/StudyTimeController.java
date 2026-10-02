package com.passjava.controller;
 import java.util.Arrays;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.passjava.entity.StudyTimeEntity;
import com.passjava.service.StudyTimeService;
import com.passjava.utils.PageUtils;
import com.passjava.utils.R;
import com.passjava.conDTO.R;
@RestController
@RequestMapping("study/studytime")
public class StudyTimeController {

@Autowired
 private  StudyTimeService studyTimeService;


@RequestMapping("/member/list/test/{id}")
public R getMemberStudyTimeListTest(Long id){
    return studyTimeService.getMemberStudyTimeListTest(id);
}


@RequestMapping("/save")
public R save(StudyTimeEntity studyTime){
    studyTimeService.save(studyTime);
    return R.ok();
}


@RequestMapping("/update")
public R update(StudyTimeEntity studyTime){
    studyTimeService.updateById(studyTime);
    return R.ok();
}


@RequestMapping("/list")
public R list(Map<String,Object> params){
    PageUtils page = studyTimeService.queryPage(params);
    return R.ok().put("page", page);
}


@RequestMapping("/delete")
public R delete(Long[] ids){
    studyTimeService.removeByIds(Arrays.asList(ids));
    return R.ok();
}


@RequestMapping("/info/{id}")
public R info(Long id){
    StudyTimeEntity studyTime = studyTimeService.getById(id);
    return R.ok().put("studyTime", studyTime);
}


}