package com.passjava.controller;
 import java.util;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.passjava.entity.QuestionEntity;
import com.passjava.service.IQuestionService;
import com.passjava.utils.R;
import javax.validation.Valid;
@RestController
@RequestMapping("question/v1/admin/question")
@Slf4j
public class QuestionController {

@Autowired
 private  IQuestionService questionService;


@RequestMapping("/test")
@Cacheable(value = "hot", key = "#root.method.name")
public int test(){
    return 222;
}


@RequestMapping("/save")
public R save(QuestionEntity question){
    questionService.saveQuestion(question);
    return R.ok();
}


@RequestMapping("/update")
public R update(QuestionEntity question){
    questionService.updateQuestion(question);
    return R.ok();
}


@RequestMapping("/create")
public R create(QuestionEntity question){
    questionService.createQuestion(question);
    return R.ok();
}


@RequestMapping("/list")
public R list(Page<QuestionEntity> page,Map<String,Object> params){
    long time = System.currentTimeMillis();
    IPage<QuestionEntity> page1 = questionService.queryPage1(page, params);
    log.info("耗时：{}", System.currentTimeMillis() - time);
    return R.ok().put("page", page1);
}


@RequestMapping("/delete")
@CacheEvict(value = "hot")
public R delete(Long[] ids){
    questionService.removeByIds(Arrays.asList(ids));
    return R.ok();
}


@RequestMapping("/remove/{id}")
@CacheEvict(value = "hot")
public R remove(Long id){
    questionService.removeById(id);
    return R.ok();
}


@RequestMapping("/info/{id}")
public R info(Long id){
    QuestionEntity question = questionService.info(id);
    return R.ok().put("question", question);
}


}