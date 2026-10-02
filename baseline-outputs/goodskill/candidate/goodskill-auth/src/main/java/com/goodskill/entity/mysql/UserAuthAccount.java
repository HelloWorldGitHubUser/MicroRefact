package com.goodskill.entity.mysql;
 import com.goodskill.entity.BaseColEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.io.Serial;
import java.io.Serializable;
@Data
@EqualsAndHashCode(callSuper = false)
public class UserAuthAccount extends BaseColEntityimplements Serializable{

@Serial
 private  long serialVersionUID;

 private  Long id;

 private  Integer userId;

 private  String thirdAccountId;

 private  String thirdAccountName;

 private  String sourceType;


}