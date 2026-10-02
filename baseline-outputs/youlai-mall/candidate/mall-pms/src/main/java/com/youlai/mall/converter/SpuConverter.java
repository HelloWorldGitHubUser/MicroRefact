package com.youlai.mall.converter;
 import com.youlai.mall.model.pms.entity.PmsSpu;
import com.youlai.mall.model.pms.form.PmsSpuForm;
import com.youlai.mall.model.pms.vo.SeckillingSpuVO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import java.util.List;
@Mapper(componentModel = "spring")
public interface SpuConverter {


@InheritInverseConfiguration(name = "form2Entity")
public PmsSpuForm entity2Form(PmsSpu entity)
;

public List<SeckillingSpuVO> entity2SeckillingVO(List<PmsSpu> entities)
;

@Mappings({ @Mapping(target = "album", source = "subPicUrls") })
public PmsSpu form2Entity(PmsSpuForm form)
;

}