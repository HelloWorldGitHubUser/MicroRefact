package com.goodskill.dto;
 import lombok.Data;
import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
@Data
public class SeckillInfoDTO implements Serializable{

@Serial
 private  long serialVersionUID;

 private  Long seckillId;

 private  String name;

 private  Integer number;

 private  Date startTime;

 private  Date endTime;

 private  Date createTime;

 private  Integer goodsId;

 private  BigDecimal price;

 private  String goodsName;


}