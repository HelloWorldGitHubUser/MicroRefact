package com.goodskill.dto;
 import lombok.Data;
import java.io.Serial;
import java.io.Serializable;
@Data
public class GoodsDTO implements Serializable{

@Serial
 private  long serialVersionUID;

 private  long id;

 private  Integer goodsId;

 private  String photoUrl;

 private  String name;

 private  String price;

 private  String introduce;

 private  String rawName;


}