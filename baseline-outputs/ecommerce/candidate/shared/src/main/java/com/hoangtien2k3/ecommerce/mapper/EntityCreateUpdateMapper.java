package com.hoangtien2k3.ecommerce.mapper;
 import org.mapstruct.BeanMapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
public interface EntityCreateUpdateMapper {


@BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public void partialUpdate(M m,V v)
;

public M toModel(V vm)
;

public V toVm(M m)
;

public R toVmResponse(M m)
;

}