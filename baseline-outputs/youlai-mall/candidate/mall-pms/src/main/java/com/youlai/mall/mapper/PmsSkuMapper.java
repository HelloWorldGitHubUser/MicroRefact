package com.youlai.mall.mapper;
 import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.youlai.mall.model.pms.dto.SkuInfoDTO;
import com.youlai.mall.model.pms.entity.PmsSku;
import org.apache.ibatis.annotations.Mapper;
@Mapper
public interface PmsSkuMapper extends BaseMapper<PmsSku>{


public SkuInfoDTO getSkuInfo(Long skuId)
;

}