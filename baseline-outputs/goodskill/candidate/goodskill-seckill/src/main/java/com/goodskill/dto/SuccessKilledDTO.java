package com.goodskill.dto;
 import lombok.Data;
import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
@Data
public class SuccessKilledDTO implements Serializable{

@Serial
 private  long serialVersionUID;

 private  Long seckillId;

 private  String userPhone;

 private  Integer status;

 private  Date createTime;

 private  String serverIp;

 private  String userIp;

 private  String userId;


}