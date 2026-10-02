package com.youlai.mall.converter;
 import com.youlai.mall.model.oms.dto.CartItemDto;
import com.youlai.mall.model.pms.dto.SkuInfoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
@Mapper(componentModel = "spring")
public interface CartConverter {


@Mappings({ @Mapping(target = "skuId", source = "id") })
public CartItemDto sku2CartItem(SkuInfoDTO skuInfo)
;

}