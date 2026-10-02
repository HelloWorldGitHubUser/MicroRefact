package io.gulimall.DTO;
 import java.math.BigDecimal;
import java.util.List;
public class CartVo {

 private  List<CartItemVo> items;

 private  Integer countNum;

 private  Integer countType;

 private  BigDecimal totalAmount;

 private  BigDecimal reduce;


public Integer getCountNum(){
    int count = 0;
    if (items != null) {
        for (CartItemVo item : items) {
            count += item.getCount();
        }
    }
    return count;
}


public List<CartItemVo> getItems(){
    return items;
}


public BigDecimal getReduce(){
    return reduce;
}


public BigDecimal getTotalAmount(){
    BigDecimal total = BigDecimal.ZERO;
    if (items != null) {
        for (CartItemVo item : items) {
            // 只计算选中的商品
            if (item.getCheck() != null && item.getCheck()) {
                total = total.add(item.getTotalPrice());
            }
        }
    }
    total = total.subtract(reduce);
    return total;
}


public Integer getCountType(){
    int count = 0;
    if (items != null) {
        for (CartItemVo ignored : items) {
            count += 1;
        }
    }
    return count;
}


}