package com.youlai.mall.NEWInstance;
 import org.springframework.web.bind.annotation.*;
@RestController
@CrossOrigin
public class PageResultController {

 private PageResult pageresult;

 private PageResult pageresult;


@GetMapping
("/success")
public PageResult<T> success(@RequestParam(name = "page") IPage<T> page){
  return pageresult.success(page);
}


}