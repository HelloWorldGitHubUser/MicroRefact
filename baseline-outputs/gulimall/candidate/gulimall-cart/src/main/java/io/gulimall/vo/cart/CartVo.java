package io.gulimall.vo.cart;
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


public void setTotalAmount(BigDecimal totalAmount){
    this.totalAmount = totalAmount;
}


public void setCountType(Integer countType){
    this.countType = countType;
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


public void setItems(List<CartItemVo> items){
    this.items = items;
}


public void setReduce(BigDecimal reduce){
    this.reduce = reduce;
}


public void setCountNum(Integer countNum){
    this.countNum = countNum;
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