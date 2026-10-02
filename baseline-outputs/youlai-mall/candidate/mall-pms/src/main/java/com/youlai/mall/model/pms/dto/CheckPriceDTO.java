package com.youlai.mall.model.pms.dto;
 import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CheckPriceDTO {

 private  Long totalAmount;

 private  List<OrderSku> skus;

 private  Long skuId;

 private  Integer count;


}