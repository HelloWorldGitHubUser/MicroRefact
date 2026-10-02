package com.youlai.mall.converter;
 import com.youlai.mall.model.ums.dto.MemberAuthDTO;
import com.youlai.mall.model.ums.dto.MemberRegisterDto;
import com.youlai.mall.model.ums.dto.MemberInfoDTO;
import com.youlai.mall.model.ums.entity.UmsMember;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
@Mapper(componentModel = "spring")
public interface MemberConvert {


@Mappings({ @Mapping(target = "username", source = "mobile") })
public MemberAuthDTO entity2MobileAuthDTO(UmsMember entity)
;

@Mappings({ @Mapping(target = "username", source = "openid") })
public MemberAuthDTO entity2OpenidAuthDTO(UmsMember entity)
;

public UmsMember dto2Entity(MemberRegisterDto memberRegisterDTO)
;

public MemberInfoDTO entity2MemberInfoDTO(UmsMember entity)
;

}