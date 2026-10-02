package com.passjava.controller;
 import com.passjava.utils.R;
import com.passjava.entity.QuestionEntity;
import com.passjava.service.IQuestionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation;
import java.util;
import com.passjava.conDTO.R;
@RestController
@RequestMapping("question/v1/app/question")
@Slf4j
public class QuestionAppController {

@Autowired
 private  IQuestionService questionService;


@RequestMapping("/list/{type}")
public R list(String type){
    long time = System.currentTimeMillis();
    List<QuestionEntity> list = questionService.list(type);
    log.info("耗时：{}", System.currentTimeMillis() - time);
    return R.ok().put("list", list);
}


@RequestMapping("/info/{id}")
public R info(Long id){
    QuestionEntity question = questionService.info(id);
    return R.ok().put("question", question);
}


}