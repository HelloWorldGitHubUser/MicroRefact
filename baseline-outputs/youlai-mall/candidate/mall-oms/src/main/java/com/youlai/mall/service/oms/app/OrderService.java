package com.youlai.mall.service.oms.app;
 import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.github.binarywang.wxpay.bean.notify.SignatureHeader;
import com.github.binarywang.wxpay.exception.WxPayException;
import com.youlai.mall.model.oms.entity.OmsOrder;
import com.youlai.mall.model.oms.form.OrderPaymentForm;
import com.youlai.mall.model.oms.form.OrderSubmitForm;
import com.youlai.mall.model.oms.query.OrderPageQuery;
import com.youlai.mall.model.oms.vo.OrderConfirmVO;
import com.youlai.mall.model.oms.vo.OrderPageVO;
public interface OrderService extends IService<OmsOrder>{


public OrderConfirmVO confirmOrder(Long skuId)
;

public IPage<OrderPageVO> getOrderPage(OrderPageQuery queryParams)
;

public String submitOrder(OrderSubmitForm orderSubmitForm)
;

public boolean closeOrder(String orderSn)
;

public boolean deleteOrder(Long id)
;

public void handleWxPayOrderNotify(SignatureHeader signatureHeader,String notifyData) throws WxPayException
;

public void handleWxPayRefundNotify(SignatureHeader signatureHeader,String notifyData) throws WxPayException
;

public T payOrder(OrderPaymentForm paymentForm)
;

}