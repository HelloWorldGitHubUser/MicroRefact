package com.youlai.mall.service.oms.app;
 import com.baomidou.mybatisplus.extension.service.IService;
import com.youlai.mall.model.oms.entity.OmsOrderLog;
public interface OrderLogService extends IService<OmsOrderLog>{


public void addOrderLogs(Long orderId,Integer orderStatus,String detail)
;

}