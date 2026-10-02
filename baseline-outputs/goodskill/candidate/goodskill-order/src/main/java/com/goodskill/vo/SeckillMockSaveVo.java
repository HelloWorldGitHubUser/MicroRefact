package com.goodskill.vo;
 import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serial;
import java.io.Serializable;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SeckillMockSaveVo implements Serializable{

@Serial
 private  long serialVersionUID;

 private  long seckillId;

 private  String userPhone;

 private  String note;


}