package io.gulimall.entity.coupon;
 import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.math.BigDecimal;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;
@Data
@TableName("sms_seckill_sku_relation")
public class SeckillSkuRelationEntity implements Serializable{

 private  long serialVersionUID;

@TableId
 private  Long id;

 private  Long promotionId;

 private  Long promotionSessionId;

 private  Long skuId;

 private  BigDecimal seckillPrice;

 private  BigDecimal seckillCount;

 private  BigDecimal seckillLimit;

 private  Integer seckillSort;


}