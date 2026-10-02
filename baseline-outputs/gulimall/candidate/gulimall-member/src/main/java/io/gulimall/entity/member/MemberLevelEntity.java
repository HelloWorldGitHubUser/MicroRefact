package io.gulimall.entity.member;
 import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.math.BigDecimal;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;
@Data
@TableName("ums_member_level")
public class MemberLevelEntity implements Serializable{

 private  long serialVersionUID;

@TableId
 private  Long id;

 private  String name;

 private  Integer growthPoint;

 private  Integer defaultStatus;

 private  BigDecimal freeFreightPoint;

 private  Integer commentGrowthPoint;

 private  Integer priviledgeFreeFreight;

 private  Integer priviledgeMemberPrice;

 private  Integer priviledgeBirthday;

 private  String note;


}