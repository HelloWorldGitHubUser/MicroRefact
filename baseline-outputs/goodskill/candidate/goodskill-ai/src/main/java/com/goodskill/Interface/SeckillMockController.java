package com.goodskill.Interface;
public interface SeckillMockController {

   public Result<Long> doWithSychronized(SeckillWebMockRequestDTO dto);
   public Result<String> getTaskTimeInfo(Long seckillId);
}