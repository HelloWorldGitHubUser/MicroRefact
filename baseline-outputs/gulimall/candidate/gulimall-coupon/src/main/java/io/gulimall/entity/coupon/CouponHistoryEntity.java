package io.gulimall.entity.coupon;
 import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;
@Data
@TableName("sms_coupon_history")
public class CouponHistoryEntity implements Serializable{

 private  long serialVersionUID;

@TableId
 private  Long id;

 private  Long couponId;

 private  Long memberId;

 private  String memberNickName;

 private  Integer getType;

 private  Date createTime;

 private  Integer useType;

 private  Date useTime;

 private  Long orderId;

 private  Long orderSn;


}