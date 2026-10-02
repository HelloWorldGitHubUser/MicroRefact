package com.goodskill.NEWInstance;
 import org.springframework.web.bind.annotation.*;
@RestController
@CrossOrigin
public class SeckillMockControllerController {

 private SeckillMockController seckillmockcontroller;


@GetMapping
("/doWithSychronized")
public Result<Long> doWithSychronized(@RequestParam(name = "dto") SeckillWebMockRequestDTO dto){
  return seckillmockcontroller.doWithSychronized(dto);
}


@GetMapping
("/getTaskTimeInfo")
public Result<String> getTaskTimeInfo(@RequestParam(name = "seckillId") Long seckillId){
  return seckillmockcontroller.getTaskTimeInfo(seckillId);
}


}