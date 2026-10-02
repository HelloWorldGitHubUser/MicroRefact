package com.goodskill.dto;
 import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
@Data
public class SeckillWebMockRequestDTO {

@NotNull
 private  Long seckillId;

@Min(1)
 private  int seckillCount;

@Min(1)
 private  int requestCount;

 private  String taskId;

 private  Integer corePoolSize;

 private  Integer maxPoolSize;

 private  boolean allowVirtualThread;


}