package io.gulimall.service.seckill;
 import io.gulimall.to.seckill.SeckillSkuRedisTo;
import java.util.List;
public interface SeckillService {


public void uploadSeckillSkuLatest3Days()
;

public SeckillSkuRedisTo getSeckillSkuInfo(Long skuId)
;

public List<SeckillSkuRedisTo> getCurrentSeckillSkus()
;

public String kill(String killId,String key,Integer num) throws InterruptedException
;

}