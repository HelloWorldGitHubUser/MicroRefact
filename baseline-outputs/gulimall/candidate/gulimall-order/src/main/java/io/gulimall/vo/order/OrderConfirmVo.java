package io.gulimall.vo.order;
 import io.gulimall.vo.MemberAddressVo;
import io.gulimall.vo.OrderItemVo;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
public class OrderConfirmVo {

@Getter
@Setter
 private  List<MemberAddressVo> memberAddressVos;

@Getter
@Setter
 private  List<OrderItemVo> items;

@Getter
@Setter
 private  Integer integration;

@Getter
@Setter
 private  String orderToken;

@Getter
@Setter
 private Map<Long,Boolean> stocks;


public BigDecimal getPayPrice(){
    return getTotal();
}


public BigDecimal getTotal(){
    BigDecimal totalNum = BigDecimal.ZERO;
    if (items != null && items.size() > 0) {
        for (OrderItemVo item : items) {
            // 计算当前商品的总价格
            BigDecimal itemPrice = item.getPrice().multiply(new BigDecimal(item.getCount().toString()));
            // 再计算全部商品的总价格
            totalNum = totalNum.add(itemPrice);
        }
    }
    return totalNum;
}


public Integer getCount(){
    Integer count = 0;
    if (items != null && items.size() > 0) {
        for (OrderItemVo item : items) {
            count += item.getCount();
        }
    }
    return count;
}


}