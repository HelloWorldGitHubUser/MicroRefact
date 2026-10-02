package com.youlai.mall.util;
 import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.NumberUtil;
import com.youlai.mall.base.IBaseEnum;
import com.youlai.mall.enums.CouponFaceValueTypeEnum;
import com.youlai.mall.enums.ValidityPeriodTypeEnum;
import java.math.BigDecimal;
import java.util.Date;
public class CouponUtils {


public String getFaceValue(Integer faceValueType,Long faceValue,BigDecimal discount){
    String faceValueLabel = null;
    if (faceValueType == null) {
        return null;
    }
    CouponFaceValueTypeEnum couponFaceValueTypeEnum = IBaseEnum.getEnumByValue(faceValueType, CouponFaceValueTypeEnum.class);
    switch(couponFaceValueTypeEnum) {
        case CASH:
            faceValueLabel = NumberUtil.toStr(NumberUtil.div(faceValue, new Float(100), 2)) + "元";
            break;
        case DISCOUNT:
            faceValueLabel = NumberUtil.mul(discount, 10) + "折";
            break;
    }
    return faceValueLabel;
}


public String getValidityPeriod(Integer validityPeriodType,Integer validityDays,Date validityBeginTime,Date validityEndTime){
    String validityPeriodLabel = null;
    if (validityPeriodType == null) {
        return null;
    }
    ValidityPeriodTypeEnum validityPeriodTypeEnum = IBaseEnum.getEnumByValue(validityPeriodType, ValidityPeriodTypeEnum.class);
    switch(validityPeriodTypeEnum) {
        case DATE_RANGE:
            validityPeriodLabel = DateUtil.format(validityBeginTime, "yyyy/MM/dd") + "~" + DateUtil.format(validityEndTime, "yyyy/MM/dd");
            break;
        case FIXED_DAYS:
            validityPeriodLabel = "领取后" + validityDays + "天有效";
            break;
    }
    return validityPeriodLabel;
}


}