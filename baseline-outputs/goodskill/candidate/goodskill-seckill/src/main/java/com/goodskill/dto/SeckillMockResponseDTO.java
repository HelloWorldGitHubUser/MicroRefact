package com.goodskill.dto;
 import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serial;
import java.io.Serializable;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SeckillMockResponseDTO implements Serializable{

@Serial
 private  long serialVersionUID;

 private  long seckillId;

 private  String note;

 private  Boolean status;

 private  String taskId;


}