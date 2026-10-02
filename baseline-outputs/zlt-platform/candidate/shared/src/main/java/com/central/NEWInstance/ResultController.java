package com.central.NEWInstance;
 import org.springframework.web.bind.annotation.*;
@RestController
@CrossOrigin
public class ResultController {

 private Result result;

 private Result result;


@GetMapping
("/failed")
public Result<T> failed(@RequestParam(name = "model") T model,@RequestParam(name = "msg") String msg){
  return result.failed(model,msg);
}


@GetMapping
("/succeed")
public Result<T> succeed(@RequestParam(name = "model") T model){
  return result.succeed(model);
}


}