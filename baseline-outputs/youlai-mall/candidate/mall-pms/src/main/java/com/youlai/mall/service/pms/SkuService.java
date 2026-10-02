package com.youlai.mall.service.pms;
 import com.baomidou.mybatisplus.extension.service.IService;
import com.youlai.mall.model.pms.dto.LockSkuDTO;
import com.youlai.mall.model.pms.dto.SkuInfoDTO;
import com.youlai.mall.model.pms.entity.PmsSku;
import java.util.List;
public interface SkuService extends IService<PmsSku>{


public boolean lockStock(String orderToken,List<LockSkuDTO> lockSkuList)
;

public boolean deductStock(String orderSn)
;

public SkuInfoDTO getSkuInfo(Long skuId)
;

public List<SkuInfoDTO> listSkuInfos(List<Long> skuIds)
;

public List<SkuInfoDTO> getSkuInfoList(List<Long> skuIds){
    return listSkuInfos(skuIds);
}
;

public boolean unlockStock(String orderSn)
;

}