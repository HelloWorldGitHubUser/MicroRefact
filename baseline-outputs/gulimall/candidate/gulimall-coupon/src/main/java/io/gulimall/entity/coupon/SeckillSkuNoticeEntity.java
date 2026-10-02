package io.gulimall.entity.coupon;
 import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;
@Data
@TableName("sms_seckill_sku_notice")
public class SeckillSkuNoticeEntity implements Serializable{

 private  long serialVersionUID;

@TableId
 private  Long id;

 private  Long memberId;

 private  Long skuId;

 private  Long sessionId;

 private  Date subcribeTime;

 private  Date sendTime;

 private  Integer noticeType;


}