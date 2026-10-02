package com.youlai.mall.model.pms.vo;
 import com.youlai.mall.base.BaseVO;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
@Builder
public class OrderItemVO extends BaseVO{

@Getter
@Setter
 private  Long skuId;

@Getter
@Setter
 private  String skuImg;

@Getter
@Setter
 private  String title;

@Getter
@Setter
 private  Integer number;

@Getter
@Setter
 private  Long price;

@Getter
@Setter
 private  Long coupon;

@Setter
 private  Long subTotal;


public Long getSubTotal(){
    Long total = 0L;
    if (price != null && number != null) {
        total = price * number;
    }
    return total;
}


}