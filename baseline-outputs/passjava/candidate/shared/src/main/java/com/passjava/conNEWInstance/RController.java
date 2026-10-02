package com.passjava.conNEWInstance;
 import org.springframework.web.bind.annotation.*;
@RestController
@CrossOrigin
public class RController {

 private R r;

 private R r;


@GetMapping
("/put")
public R put(@RequestParam(name = "key") String key,@RequestParam(name = "value") Object value){
  return r.put(key,value);
}


@GetMapping
("/error")
public R error(@RequestParam(name = "code") int code,@RequestParam(name = "msg") String msg){
  return r.error(code,msg);
}


@GetMapping
("/ok")
public R ok(){
  return r.ok();
}


}