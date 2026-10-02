package com.goodskill.dto;
 import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serial;
import java.io.Serializable;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SeckillMockRequestDTO implements Serializable{

@Serial
 private  long serialVersionUID;

 private  long seckillId;

 private  int count;

 private  String phoneNumber;

 private  String requestTime;

 private  String taskId;

public SeckillMockRequestDTO(long seckillId, int count, String phoneNumber) {
    this.seckillId = seckillId;
    this.count = count;
    this.phoneNumber = phoneNumber;
}public SeckillMockRequestDTO(long seckillId, int count, String phoneNumber, String taskId) {
    this.seckillId = seckillId;
    this.count = count;
    this.phoneNumber = phoneNumber;
    this.taskId = taskId;
}
}