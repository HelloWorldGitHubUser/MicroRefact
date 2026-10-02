package com.youlai.mall.model.oms.dto;
 import lombok.Data;
import java.io.Serializable;
import java.util.Set;
@Data
public class CartItemVo implements Serializable{

 private  Long skuId;

 private  String spuName;

 private  Set<String> specs;

 private  String imageUrl;

 private  Integer count;

 private  Long price;

 private  Boolean checked;

 private  Integer stock;


}