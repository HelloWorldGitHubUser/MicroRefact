package com.youlai.mall.converter;
 import com.youlai.mall.model.ums.dto.MemberAddressDTO;
import com.youlai.mall.model.ums.entity.UmsAddress;
import org.mapstruct.Mapper;
import java.util.List;
@Mapper(componentModel = "spring")
public interface AddressConvert {


public List<MemberAddressDTO> entity2Dto(List<UmsAddress> entities)
;

}