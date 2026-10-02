package com.goodskill.NEWInstance;
 import org.springframework.web.bind.annotation.*;
@RestController
@CrossOrigin
public class ResultController {

 private Result result;

 private Result result;


@GetMapping
("/ok")
public Result<T> ok(@RequestParam(name = "data") T data,@RequestParam(name = "msg") String msg){
  return result.ok(data,msg);
}


@GetMapping
("/fail")
public Result<T> fail(@RequestParam(name = "code") int code,@RequestParam(name = "msg") String msg){
  return result.fail(code,msg);
}


}