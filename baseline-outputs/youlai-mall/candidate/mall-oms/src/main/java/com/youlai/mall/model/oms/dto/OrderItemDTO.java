package com.youlai.mall.model.oms.dto;
 import lombok.Data;
@Data
public class OrderItemDTO {

 private  Long skuId;

 private  String skuSn;

 private  String skuName;

 private  String picUrl;

 private  Long price;

 private  String spuName;

 private  Integer quantity;


}