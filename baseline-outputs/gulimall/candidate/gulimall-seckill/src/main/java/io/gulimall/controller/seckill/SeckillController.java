package io.gulimall.controller.seckill;
 import io.gulimall.security.LoginRequired;
import io.gulimall.service.seckill.SeckillService;
import io.gulimall.to.seckill.SeckillSkuRedisTo;
import io.gulimall.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;
import io.gulimall.DTO.R;
@Controller
public class SeckillController {

@Autowired
 private  SeckillService seckillService;


@GetMapping("/getSeckillSkuInfo/{skuId}")
@ResponseBody
public R getSeckillSkuInfo(Long skuId){
    return R.ok().setData(seckillService.getSeckillSkuInfo(skuId));
}


@GetMapping("/getCurrentSeckillSkus")
@ResponseBody
public R getCurrentSeckillSkus(){
    List<SeckillSkuRedisTo> skus = seckillService.getCurrentSeckillSkus();
    return R.ok().setData(skus);
}


@GetMapping("/kill")
@LoginRequired
public String kill(String killId,String key,Integer num,Model model){
    String orderSn = null;
    try {
        orderSn = seckillService.kill(killId, key, num);
    } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
    }
    model.addAttribute("orderSn", orderSn);
    return "seckill/templates/success";
}


}