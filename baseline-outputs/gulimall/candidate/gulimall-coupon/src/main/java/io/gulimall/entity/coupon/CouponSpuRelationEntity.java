package io.gulimall.entity.coupon;
 import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;
@Data
@TableName("sms_coupon_spu_relation")
public class CouponSpuRelationEntity implements Serializable{

 private  long serialVersionUID;

@TableId
 private  Long id;

 private  Long couponId;

 private  Long spuId;

 private  String spuName;


}