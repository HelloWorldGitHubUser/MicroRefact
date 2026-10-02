package com.youlai.mall.model.oms.dto;
 import lombok.Data;
import java.io.Serializable;
@Data
public class CartItemDto implements Serializable{

 private  Long skuId;

 private  Integer count;

 private  Boolean checked;


}