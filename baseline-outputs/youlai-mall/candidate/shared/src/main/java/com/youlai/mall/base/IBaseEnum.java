package com.youlai.mall.base;
 import cn.hutool.core.util.ObjectUtil;
import java.util.EnumSet;
import java.util.Objects;
public interface IBaseEnum {


public T getValue()
;

public String getLabel()
;

public Object getValueByLabel(String label,Class<E> clazz){
    if (label == null) {
        return null;
    }
    // 获取类型下的所有枚举
    EnumSet<E> allEnums = EnumSet.allOf(clazz);
    String finalLabel = label;
    E matchEnum = allEnums.stream().filter(e -> ObjectUtil.equal(e.getLabel(), finalLabel)).findFirst().orElse(null);
    Object value = null;
    if (matchEnum != null) {
        value = matchEnum.getValue();
    }
    return value;
}
;

public E getEnumByValue(Object value,Class<E> clazz){
    if (value == null) {
        return null;
    }
    // 获取类型下的所有枚举
    EnumSet<E> allEnums = EnumSet.allOf(clazz);
    E matchEnum = allEnums.stream().filter(e -> ObjectUtil.equal(e.getValue(), value)).findFirst().orElse(null);
    return matchEnum;
}
;

public String getLabelByValue(Object value,Class<E> clazz){
    if (value == null) {
        return null;
    }
    // 获取类型下的所有枚举
    EnumSet<E> allEnums = EnumSet.allOf(clazz);
    E matchEnum = allEnums.stream().filter(e -> ObjectUtil.equal(e.getValue(), value)).findFirst().orElse(null);
    String label = null;
    if (matchEnum != null) {
        label = matchEnum.getLabel();
    }
    return label;
}
;

}