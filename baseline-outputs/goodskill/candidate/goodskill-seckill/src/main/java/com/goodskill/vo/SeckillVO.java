package com.goodskill.vo;
 import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class SeckillVO implements Serializable{

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

 private  String status;

 private  String createUser;

 private  String photoUrl;


}