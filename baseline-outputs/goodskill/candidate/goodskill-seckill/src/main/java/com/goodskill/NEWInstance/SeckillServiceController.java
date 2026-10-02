package com.goodskill.NEWInstance;
 import org.springframework.web.bind.annotation.*;
@RestController
@CrossOrigin
public class SeckillServiceController {

 private SeckillService seckillservice;


@PutMapping
("/prepareSeckill")
public void prepareSeckill(@RequestParam(name = "seckillId") Long seckillId,@RequestParam(name = "seckillCount") int seckillCount,@RequestParam(name = "taskId") String taskId){
seckillservice.prepareSeckill(seckillId,seckillCount,taskId);
}


@PutMapping
("/execute")
public void execute(@RequestParam(name = "requestDto") SeckillMockRequestDTO requestDto,@RequestParam(name = "strategyNumber") int strategyNumber){
seckillservice.execute(requestDto,strategyNumber);
}


@GetMapping
("/getSuccessKillCount")
public long getSuccessKillCount(@RequestParam(name = "seckillId") Long seckillId){
  return seckillservice.getSuccessKillCount(seckillId);
}


@GetMapping
("/endSeckill")
public boolean endSeckill(@RequestParam(name = "seckillId") Long seckillId){
  return seckillservice.endSeckill(seckillId);
}


}