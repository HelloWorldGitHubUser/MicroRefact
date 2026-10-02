package com.goodskill.controller;
 import com.goodskill.service.impl.OrderServiceImpl;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.goodskill.Interface.OrderServiceImpl;
@Tag(name = "商品管理")
@RestController
@RequestMapping("/seckill/goods")
public class GoodsController {

@Resource
 private  OrderServiceImpl orderService;


@GetMapping("/orders/count")
public Long countOrders(long seckillId){
    return orderService.count(seckillId);
}


}