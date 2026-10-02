package com.youlai.mall.converter;
 import com.youlai.mall.model.pms.entity.PmsSpuAttribute;
import com.youlai.mall.model.pms.form.PmsSpuAttributeForm;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
@Mapper(componentModel = "spring")
public interface SpuAttributeConverter {


@Mappings({ @Mapping(target = "id", ignore = true) })
public PmsSpuAttribute form2Entity(PmsSpuAttributeForm form)
;

}