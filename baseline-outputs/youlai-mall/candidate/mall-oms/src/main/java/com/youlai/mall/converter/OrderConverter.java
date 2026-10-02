package com.youlai.mall.converter;
 import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.youlai.mall.model.oms.bo.OrderBO;
import com.youlai.mall.model.oms.entity.OmsOrder;
import com.youlai.mall.model.oms.form.OrderSubmitForm;
import com.youlai.mall.model.oms.vo.OmsOrderPageVO;
import com.youlai.mall.model.oms.vo.OrderPageVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
@Mapper(componentModel = "spring")
public interface OrderConverter {


public Page<OrderPageVO> toVoPageForApp(Page<OrderBO> boPage)
;

public OmsOrderPageVO.OrderItem toVoPageOrderItem(OrderBO.OrderItem orderItem)
;

@Mappings({ @Mapping(target = "orderSn", source = "orderToken"), @Mapping(target = "totalQuantity", expression = "java(orderSubmitForm.getOrderItems().stream().map(OrderSubmitForm.OrderItem::getQuantity).reduce(0, Integer::sum))"), @Mapping(target = "totalAmount", expression = "java(orderSubmitForm.getOrderItems().stream().map(item -> item.getPrice() * item.getQuantity()).reduce(0L, Long::sum))"), @Mapping(target = "source", expression = "java(orderSubmitForm.getOrderSource().getValue())") })
public OmsOrder form2Entity(OrderSubmitForm orderSubmitForm)
;

public Page<OmsOrderPageVO> toVoPage(Page<OrderBO> boPage)
;

public OrderPageVO.OrderItem toVoPageOrderItemForApp(OrderBO.OrderItem orderItem)
;

}