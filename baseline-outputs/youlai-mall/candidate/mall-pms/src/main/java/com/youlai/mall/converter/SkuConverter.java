package com.youlai.mall.converter;
 import com.youlai.mall.model.pms.dto.SkuInfoDTO;
import com.youlai.mall.model.pms.entity.PmsSku;
import org.mapstruct.Mapper;
import java.util.List;
@Mapper(componentModel = "spring")
public interface SkuConverter {


public List<SkuInfoDTO> entity2SkuInfoDto(List<PmsSku> list)
;

}