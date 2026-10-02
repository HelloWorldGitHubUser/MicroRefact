package com.youlai.mall.controller;
 import com.github.binarywang.wxpay.bean.notify.SignatureHeader;
import com.github.binarywang.wxpay.constant.WxPayConstants;
import com.github.binarywang.wxpay.exception.WxPayException;
import com.youlai.mall.model.oms.vo.WxPayResponseVO;
import com.youlai.mall.service.oms.app.OrderService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation;
@Tag(name = "App-微信支付回调接口")
@Slf4j
@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/callback-api/v1/wx-pay")
public class WxPayCallbackController {

 private  OrderService orderService;


@PostMapping("/notify-order-v3")
public WxPayResponseVO wxPayOrderNotify(String notifyData,HttpHeaders headers) throws WxPayException{
    SignatureHeader signatureHeader = getSignatureHeaderByHttpHeaders(headers);
    orderService.handleWxPayOrderNotify(signatureHeader, notifyData);
    return new WxPayResponseVO().setCode(WxPayConstants.ResultCode.SUCCESS).setMessage("成功");
}


public SignatureHeader getSignatureHeaderByHttpHeaders(HttpHeaders headers){
    SignatureHeader signatureHeader = new SignatureHeader();
    signatureHeader.setSignature(headers.getFirst("Wechatpay-Signature"));
    signatureHeader.setSerial(headers.getFirst("Wechatpay-Serial"));
    signatureHeader.setTimeStamp(headers.getFirst("Wechatpay-Timestamp"));
    signatureHeader.setNonce(headers.getFirst("Wechatpay-Nonce"));
    return signatureHeader;
}


@PostMapping("/notify-refund-v3")
public WxPayResponseVO wxPayRefundNotify(String notifyData,HttpHeaders headers) throws WxPayException{
    SignatureHeader signatureHeader = getSignatureHeaderByHttpHeaders(headers);
    orderService.handleWxPayRefundNotify(signatureHeader, notifyData);
    return new WxPayResponseVO().setCode(WxPayConstants.ResultCode.SUCCESS).setMessage("成功");
}


}