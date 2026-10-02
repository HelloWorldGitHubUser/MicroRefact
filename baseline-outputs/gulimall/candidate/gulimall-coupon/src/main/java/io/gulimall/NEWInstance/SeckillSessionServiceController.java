package io.gulimall.NEWInstance;
 import org.springframework.web.bind.annotation.*;
@RestController
@CrossOrigin
public class SeckillSessionServiceController {

 private SeckillSessionService seckillsessionservice;


@GetMapping
("/getSeckillSessionsIn3Days")
public List<SeckillSessionEntity> getSeckillSessionsIn3Days(){
  return seckillsessionservice.getSeckillSessionsIn3Days();
}


}