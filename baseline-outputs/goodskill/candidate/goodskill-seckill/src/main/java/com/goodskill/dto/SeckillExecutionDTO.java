package com.goodskill.dto;
 import lombok.Data;
import java.io.Serial;
import java.io.Serializable;
@Data
public class SeckillExecutionDTO implements Serializable{

@Serial
 private  long serialVersionUID;

 private  long seckillId;

 private  String statDesc;

 private  int state;

 private  String stateInfo;

 private  SuccessKilledDTO seccessKilled;

 private  String qrfilepath;

public SeckillExecutionDTO(long seckillId, String statDesc, SuccessKilledDTO seccessKilled, String qrfilepath) {
    this.seckillId = seckillId;
    this.statDesc = statDesc;
    this.seccessKilled = seccessKilled;
    this.qrfilepath = qrfilepath;
}public SeckillExecutionDTO(long seckillId, String statDesc) {
    this.seckillId = seckillId;
    this.statDesc = statDesc;
}
}