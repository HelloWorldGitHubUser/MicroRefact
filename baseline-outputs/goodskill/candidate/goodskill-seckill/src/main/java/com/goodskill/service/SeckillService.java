package com.goodskill.service;
 import com.baomidou.mybatisplus.extension.plugins.pagination.PageDTO;
import com.goodskill.dto;
import com.goodskill.vo.SeckillVO;
import java.io.IOException;
import java.io.Serializable;
public interface SeckillService {


public long getSuccessKillCount(Long seckillId)
;

public void prepareSeckill(Long seckillId,int seckillCount,String taskId)
;

public boolean saveOrUpdateSeckill(SeckillVO seckill)
;

public int reduceNumberWithPreCheck(SuccessKilledDTO successKilled)
;

public PageDTO<SeckillVO> getSeckillList(int pageNum,int pageSize,String goodsName)
;

public boolean save(SeckillVO seckill)
;

public void execute(SeckillMockRequestDTO requestDto,int strategyNumber)
;

public boolean endSeckill(Long seckillId)
;

public int reduceNumberInner(SuccessKilledDTO successKilled)
;

public SeckillVO findById(Serializable seckillId)
;

public void deleteSuccessKillRecord(long seckillId)
;

public int reduceNumber(SuccessKilledDTO successKilled)
;

public SeckillResponseDTO getQrcode(String fileName) throws IOException
;

public SeckillInfoDTO getInfoById(Serializable seckillId)
;

public ExposerDTO exportSeckillUrl(long seckillId)
;

public boolean removeBySeckillId(Serializable seckillId)
;

}