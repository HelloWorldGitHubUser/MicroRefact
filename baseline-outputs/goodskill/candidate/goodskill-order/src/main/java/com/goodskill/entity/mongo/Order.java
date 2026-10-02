package com.goodskill.entity.mongo;
 import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document
public class Order {

@Id
 private  String id;

 private  Long seckillId;

 private  String userPhone;

 private  Byte status;

 private  LocalDateTime createTime;

 private  String serverIp;

 private  String userIp;

 private  String userId;

 private  String goodsName;

 private  String goodsTitle;

 private  String goodsImg;

 private  Double seckillPrice;

 private  String stateDesc;

 private  String alipayTradeNo;

 private  LocalDateTime payCompleteTime;


}