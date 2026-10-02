package io.gulimall.entity.coupon;
 import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.math.BigDecimal;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;
@Data
@TableName("sms_coupon")
public class CouponEntity implements Serializable{

 private  long serialVersionUID;

@TableId
 private  Long id;

 private  Integer couponType;

 private  String couponImg;

 private  String couponName;

 private  Integer num;

 private  BigDecimal amount;

 private  Integer perLimit;

 private  BigDecimal minPoint;

 private  Date startTime;

 private  Date endTime;

 private  Integer useType;

 private  String note;

 private  Integer publishCount;

 private  Integer useCount;

 private  Integer receiveCount;

 private  Date enableStartTime;

 private  Date enableEndTime;

 private  String code;

 private  Integer memberLevel;

 private  Integer publish;


}