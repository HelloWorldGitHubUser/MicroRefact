package com.passjava.service;
 import com.passjava.utils.R;
import com.passjava.dto.QuestionEsModel;
public interface SearchService {


public Object search(String keyword,Long id,Integer pageNum)
;

public R saveQuestion(QuestionEsModel questionEsModel)
;

}