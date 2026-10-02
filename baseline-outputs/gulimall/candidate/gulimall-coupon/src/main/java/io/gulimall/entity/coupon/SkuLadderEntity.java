package io.gulimall.entity.coupon;
 import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.math.BigDecimal;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;
@Data
@TableName("sms_sku_ladder")
public class SkuLadderEntity implements Serializable{

 private  long serialVersionUID;

@TableId
 private  Long id;

 private  Long skuId;

 private  Integer fullCount;

 private  BigDecimal discount;

 private  BigDecimal price;

 private  Integer addOther;


}