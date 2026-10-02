package com.passjava.controller;
 import com.passjava.utils.R;
import com.passjava.dto.QuestionEsModel;
import com.passjava.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation;
@RestController
@RequestMapping("search")
public class SearchController {

@Autowired
 private  SearchService searchService;


@GetMapping("/question/search")
public Object search(String keyword,Long id,Integer pageNum){
    return searchService.search(keyword, id, pageNum);
}


@PostMapping("/question/save")
public R saveQuestion(QuestionEsModel questionEsModel){
    return searchService.saveQuestion(questionEsModel);
}


}