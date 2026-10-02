package io.gulimall.dao.order;
 import io.gulimall.entity.order.OrderEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface OrderDao extends BaseMapper<OrderEntity>{


public void updateOrderStatus(String orderSn,Integer code,Integer payType)
;

}