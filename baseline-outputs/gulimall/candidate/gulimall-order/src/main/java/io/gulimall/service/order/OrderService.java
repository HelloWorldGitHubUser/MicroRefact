package io.gulimall.service.order;
 import com.baomidou.mybatisplus.extension.service.IService;
import io.gulimall.to.mq.SeckillOrderTo;
import io.gulimall.utils.PageUtils;
import io.gulimall.entity.order.OrderEntity;
import io.gulimall.vo.order;
import java.util.Map;
public interface OrderService extends IService<OrderEntity>{


public OrderConfirmVo confirmOrder()
;

public void handlerPayResult(PayAsyncVo payAsyncVo)
;

public void createSeckillOrder(SeckillOrderTo orderTo)
;

public SubmitOrderResponseVo submitOrder(OrderSubmitVo submitVo)
;

public boolean mockPay(String orderSn)
;

public void closeOrder(OrderEntity orderEntity)
;

public PageUtils queryPage(Map<String,Object> params)
;

public OrderEntity getOrderByOrderSn(String orderSn)
;

public PageUtils getMemberOrderPage(Map<String,Object> params)
;

public PayVo getOrderPay(String orderSn)
;

}