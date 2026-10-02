package com.youlai.mall.converter;
 import com.youlai.mall.model.sms.entity.SmsCoupon;
import com.youlai.mall.model.sms.form.CouponForm;
import com.youlai.mall.model.sms.vo.CouponPageVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import java.util.List;
@Mapper(componentModel = "spring")
public interface CouponConverter {


@Mappings({ @Mapping(target = "discount", expression = "java(cn.hutool.core.util.NumberUtil.mul(entity.getDiscount(),10L))") })
public CouponForm entity2Form(SmsCoupon entity)
;

@Mappings({ @Mapping(target = "discount", expression = "java(cn.hutool.core.util.NumberUtil.div(form.getDiscount(),10L))") })
public SmsCoupon form2Entity(CouponForm form)
;

public List<CouponPageVO> entity2PageVO(List<SmsCoupon> entities)
;

}