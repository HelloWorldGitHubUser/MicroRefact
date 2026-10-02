package com.goodskill.controller;
 import com.goodskill.dto.OrderDTO;
import com.goodskill.dto.Result;
import com.goodskill.entity.mongo.Order;
import com.goodskill.service.impl.OrderServiceImpl;
import com.goodskill.util.UserInfoUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.Map;
@Slf4j
@RestController
public class OrderController {

@Autowired
 private  OrderServiceImpl orderService;


@PostMapping("/cancel/{orderId}")
public Result<Boolean> cancelOrder(String orderId){
    boolean result = orderService.cancelOrder(orderId, UserInfoUtil.getUserId());
    return result ? Result.ok(true) : Result.fail("取消订单失败");
}


@GetMapping("/count")
public Long count(long seckillId){
    return orderService.count(seckillId);
}


@PostMapping("/saveRecord")
public String saveRecord(OrderDTO orderDTO){
    return orderService.saveRecord(orderDTO);
}


@GetMapping("/detail/{orderId}")
public Order detail(String orderId){
    return orderService.findById(orderId);
}


@GetMapping("/list")
public Result<Map<String,Object>> list(int pageNum,int pageSize){
    Page<Order> orderPage = orderService.list(UserInfoUtil.getUserId(), pageNum, pageSize);
    Map<String, Object> result = new HashMap<>();
    result.put("records", orderPage.getContent());
    result.put("total", orderPage.getTotalElements());
    result.put("size", orderPage.getSize());
    result.put("current", orderPage.getNumber() + 1);
    result.put("pages", orderPage.getTotalPages());
    return Result.ok(result);
}


@DeleteMapping("/deleteRecord")
public Boolean deleteRecord(long seckillId){
    return orderService.deleteRecord(seckillId);
}


}