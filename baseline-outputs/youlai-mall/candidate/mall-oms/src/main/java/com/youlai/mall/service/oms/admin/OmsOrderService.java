package com.youlai.mall.service.oms.admin;
 import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.youlai.mall.model.oms.entity.OmsOrder;
import com.youlai.mall.model.oms.query.OrderPageQuery;
import com.youlai.mall.model.oms.vo.OmsOrderPageVO;
public interface OmsOrderService extends IService<OmsOrder>{


public IPage<OmsOrderPageVO> getOrderPage(OrderPageQuery queryParams)
;

}