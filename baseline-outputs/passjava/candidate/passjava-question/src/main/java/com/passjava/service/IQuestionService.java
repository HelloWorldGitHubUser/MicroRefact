package com.passjava.service;
 import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.passjava.utils.PageUtils;
import com.passjava.entity.QuestionEntity;
import java.util.List;
import java.util.Map;
public interface IQuestionService extends IService<QuestionEntity>{


public boolean updateQuestion(QuestionEntity question)
;

public IPage<QuestionEntity> queryPage1(IPage<QuestionEntity> page,Map<String,Object> params)
;

public boolean saveQuestion(QuestionEntity question)
;

public List<QuestionEntity> list(String type)
;

public PageUtils queryPage(Map<String,Object> params)
;

public boolean createQuestion(QuestionEntity question)
;

public QuestionEntity info(Long id)
;

}