package io.gulimall.vo.cart;
 import java.math.BigDecimal;
import java.util.List;
public class CartItemVo {

 private  Long skuId;

 private  Boolean check;

 private  String title;

 private  String image;

 private  List<String> skuAttrValues;

 private  BigDecimal price;

 private  Integer count;

 private  BigDecimal totalPrice;


public void setTotalPrice(BigDecimal totalPrice){
    this.totalPrice = totalPrice;
}


public void setSkuId(Long skuId){
    this.skuId = skuId;
}


public Long getSkuId(){
    return skuId;
}


public void setCheck(Boolean check){
    this.check = check;
}


public void setTitle(String title){
    this.title = title;
}


public void setPrice(BigDecimal price){
    this.price = price;
}


public BigDecimal getPrice(){
    return price;
}


public Boolean getCheck(){
    return check;
}


public String getTitle(){
    return title;
}


public void setSkuAttrValues(List<String> skuAttrValues){
    this.skuAttrValues = skuAttrValues;
}


public List<String> getSkuAttrValues(){
    return skuAttrValues;
}


public BigDecimal getTotalPrice(){
    return price.multiply(new BigDecimal(count));
}


public String getImage(){
    return image;
}


public Integer getCount(){
    return count;
}


public void setCount(Integer count){
    this.count = count;
}


public void setImage(String image){
    this.image = image;
}


}