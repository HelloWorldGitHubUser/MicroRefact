package com.youlai.mall.NEWInstance;
 import org.springframework.web.bind.annotation.*;
@RestController
@CrossOrigin
public class ResultController {

 private Result result;

 private Result result;


@GetMapping
("/success")
public Result<T> success(@RequestParam(name = "data") T data){
  return result.success(data);
}


@GetMapping
("/judge")
public Result<T> judge(@RequestParam(name = "status") boolean status){
  return result.judge(status);
}


}