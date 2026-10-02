package com.youlai.mall.converter;
 import com.youlai.mall.model.oms.entity.OmsOrderItem;
import com.youlai.mall.model.oms.form.OrderSubmitForm;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import java.util.List;
@Mapper(componentModel = "spring")
public interface OrderItemConverter {


public List<OmsOrderItem> item2Entity(List<OrderSubmitForm.OrderItem> list)
;

}