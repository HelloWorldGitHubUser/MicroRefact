package com.youlai.mall.mapper;
 import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.youlai.mall.model.oms.bo.OrderBO;
import com.youlai.mall.model.oms.entity.OmsOrder;
import com.youlai.mall.model.oms.query.OrderPageQuery;
import org.apache.ibatis.annotations.Mapper;
@Mapper
public interface OrderMapper extends BaseMapper<OmsOrder>{


public Page<OrderBO> getOrderPage(Page<OrderBO> page,OrderPageQuery queryParams)
;

}