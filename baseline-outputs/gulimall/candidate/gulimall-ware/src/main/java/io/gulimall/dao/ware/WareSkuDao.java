package io.gulimall.dao.ware;
 import io.gulimall.entity.ware.WareSkuEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;
@Mapper
public interface WareSkuDao extends BaseMapper<WareSkuEntity>{


public Integer getTotalStock(Long id)
;

public void addstock(Long skuId,Long wareId,Integer skuNum)
;

public Long lockWareSku(Long skuId,Integer num,Long wareId)
;

public List<Long> listWareIdsHasStock(Long skuId,Integer count)
;

public void unlockStock(Long skuId,Integer skuNum,Long wareId)
;

}