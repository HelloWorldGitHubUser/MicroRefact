package com.passjava.controller;
 import java.util.Arrays;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.passjava.entity.NewsEntity;
import com.passjava.service.NewsService;
import com.passjava.utils.PageUtils;
import com.passjava.utils.R;
@RestController
@RequestMapping("content/news")
public class NewsController {

@Autowired
 private  NewsService newsService;


@RequestMapping("/save")
public R save(NewsEntity news){
    newsService.save(news);
    return R.ok();
}


@RequestMapping("/update")
public R update(NewsEntity news){
    newsService.updateById(news);
    return R.ok();
}


@RequestMapping("/list")
public R list(Map<String,Object> params){
    PageUtils page = newsService.queryPage(params);
    return R.ok().put("page", page);
}


@RequestMapping("/delete")
public R delete(Long[] ids){
    newsService.removeByIds(Arrays.asList(ids));
    return R.ok();
}


@RequestMapping("/info/{id}")
public R info(Long id){
    NewsEntity news = newsService.getById(id);
    return R.ok().put("news", news);
}


}