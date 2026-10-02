package io.gulimall.service.ware;
 import com.baomidou.mybatisplus.extension.service.IService;
import io.gulimall.vo.SkuHasStockVo;
import io.gulimall.to.mq.OrderTo;
import io.gulimall.utils.PageUtils;
import io.gulimall.entity.ware.WareSkuEntity;
import io.gulimall.vo.WareSkuLockVo;
import java.util.List;
import java.util.Map;
public interface WareSkuService extends IService<WareSkuEntity>{


public void unlock(OrderTo orderTo)
;

public void addStock(Long skuId,Long wareId,Integer skuNum)
;

public PageUtils queryPage(Map<String,Object> params)
;

public Boolean orderLockStock(WareSkuLockVo lockVo)
;

public List<SkuHasStockVo> getSkuHasStocks(List<Long> ids)
;

public void releaseExpiredLocks(long maxLockMinutes)
;

}