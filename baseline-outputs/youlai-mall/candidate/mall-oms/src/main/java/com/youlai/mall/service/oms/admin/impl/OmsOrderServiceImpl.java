package com.youlai.mall.service.oms.admin.impl;
 import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.youlai.mall.converter.OrderConverter;
import com.youlai.mall.mapper.OrderMapper;
import com.youlai.mall.model.oms.bo.OrderBO;
import com.youlai.mall.model.oms.entity.OmsOrder;
import com.youlai.mall.model.oms.query.OrderPageQuery;
import com.youlai.mall.model.oms.vo.OmsOrderPageVO;
import com.youlai.mall.service.oms.admin.OmsOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
@Service
@RequiredArgsConstructor
public class OmsOrderServiceImpl extends ServiceImpl<OrderMapper, OmsOrder>implements OmsOrderService{

 private  OrderConverter orderConverter;


@Override
public IPage<OmsOrderPageVO> getOrderPage(OrderPageQuery queryParams){
    Page<OrderBO> boPage = this.baseMapper.getOrderPage(new Page<>(queryParams.getPageNum(), queryParams.getPageSize()), queryParams);
    return orderConverter.toVoPage(boPage);
}


}