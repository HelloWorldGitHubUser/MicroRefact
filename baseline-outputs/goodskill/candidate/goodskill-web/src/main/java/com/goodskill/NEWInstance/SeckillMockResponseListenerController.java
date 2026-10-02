package com.goodskill.NEWInstance;
 import org.springframework.web.bind.annotation.*;
@RestController
@CrossOrigin
public class SeckillMockResponseListenerController {

 private SeckillMockResponseListener seckillmockresponselistener;


@PutMapping
("/handleSeckillResult")
public void handleSeckillResult(@RequestParam(name = "responseDto") SeckillMockResponseDTO responseDto){
seckillmockresponselistener.handleSeckillResult(responseDto);
}


}