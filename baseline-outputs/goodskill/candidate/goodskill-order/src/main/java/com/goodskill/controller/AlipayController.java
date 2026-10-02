package com.goodskill.controller;
 import com.goodskill.dto.AlipayRequestDTO;
import com.goodskill.dto.AlipayResponseDTO;
import com.goodskill.dto.Result;
import com.goodskill.enums.OrderStatusEnum;
import com.goodskill.service.AlipayService;
import com.goodskill.service.impl.OrderServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;
import com.goodskill.DTO.Result;
@RestController
@RequestMapping("/pay/alipay")
@Slf4j
public class AlipayController {

@Autowired
 private  AlipayService alipayService;

@Autowired
 private  OrderServiceImpl orderService;


@PostMapping("/callback")
public String handleCallback(Map<String,String> params){
    log.info("支付宝异步回调参数: {}", params);
    return alipayService.handleCallback(params);
}


@PostMapping("/create")
public Result<AlipayResponseDTO> createPayOrder(AlipayRequestDTO request){
    AlipayResponseDTO response = alipayService.createPayOrder(request);
    return "FAILED".equals(response.getStatus()) ? Result.fail(response, "创建支付订单失败") : Result.ok(response);
}


@GetMapping("/query/{orderId}")
public Result<AlipayResponseDTO> queryPayStatus(String orderId){
    return Result.ok(alipayService.queryPayStatus(orderId));
}


@GetMapping("/return")
public String handleReturn(String orderId,String tradeStatus,String tradeNo,Map<String,String> allParams){
    boolean signVerified = alipayService.verifyCallbackSignature(allParams);
    if (signVerified && ("TRADE_SUCCESS".equals(tradeStatus) || tradeStatus == null)) {
        OrderStatusEnum paidStatus = OrderStatusEnum.PAID;
        orderService.updateOrderStatus(orderId, paidStatus.getCode(), paidStatus.getDesc(), tradeNo, allParams.get("timestamp"));
    }
    return "<script>window.location.href='http://localhost:5174/order/" + orderId + "';</script>";
}


}