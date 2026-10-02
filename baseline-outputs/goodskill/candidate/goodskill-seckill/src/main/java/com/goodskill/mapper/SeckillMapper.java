package com.goodskill.mapper;
 import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.goodskill.entity.mysql.Seckill;
import org.apache.ibatis.annotations.Param;
import java.util.Date;
public interface SeckillMapper extends BaseMapper<Seckill>{


public int reduceNumber(long seckillId,Date killTime)
;

public int reduceNumberOptimized(long seckillId,Date killTime,int number)
;

}