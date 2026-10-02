package com.goodskill.executor;
 public interface SeckillExecutor {


public void dealSeckill(long seckillId,String userPhone,String note,String taskId)
;

public void dealSeckillWithPreCheck(long seckillId,String userPhone,String note,String taskId,boolean hasStockChecked)
;

}