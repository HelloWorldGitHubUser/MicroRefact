package io.gulimall.entity.coupon;
 import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.math.BigDecimal;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;
@Data
@TableName("sms_spu_bounds")
public class SpuBoundsEntity implements Serializable{

 private  long serialVersionUID;

@TableId
 private  Long id;

 private  Long spuId;

 private  BigDecimal growBounds;

 private  BigDecimal buyBounds;

 private  Integer work;


}