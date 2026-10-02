package com.goodskill.controller;
 import com.goodskill.dto.Result;
import com.goodskill.entity.mongo.Order;
import com.goodskill.service.impl.OrderServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Slf4j
@RestController
@RequestMapping("/admin")
public class AdminOrderController {

@Autowired
 private  OrderServiceImpl orderService;


@DeleteMapping("/deleteById")
public Boolean deleteById(String id){
    return orderService.deleteById(id);
}


@GetMapping("/detail")
public Order detail(String id){
    return orderService.findById(id);
}


@GetMapping("/list")
public Result<Map<String,Object>> list(int page,int size,String orderId,Long seckillId,String userPhone,Long userId,Integer status,String startTime,String endTime){
    Page<Order> orderPage = orderService.adminList(page, size, orderId, seckillId, userPhone, userId, status, startTime, endTime);
    Map<String, Object> result = new HashMap<>();
    result.put("records", orderPage.getContent());
    result.put("total", orderPage.getTotalElements());
    result.put("size", orderPage.getSize());
    result.put("current", orderPage.getNumber() + 1);
    result.put("pages", orderPage.getTotalPages());
    return Result.ok(result);
}


@DeleteMapping("/batch")
public Boolean batchDelete(List<String> ids){
    return orderService.batchDelete(ids);
}


}