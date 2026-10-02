package com.goodskill.vo;
 import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class GoodsVO implements Serializable{

@Serial
 private  long serialVersionUID;

 private  Integer goodsId;

 private  String photoUrl;

 private  String name;

 private  String price;

 private  Date createTime;

 private  String introduce;


}