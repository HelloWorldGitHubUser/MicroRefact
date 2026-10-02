package io.gulimall.entity.ware;
 import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.math.BigDecimal;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;
@Data
@TableName("wms_purchase_detail")
public class PurchaseDetailEntity implements Serializable{

 private  long serialVersionUID;

@TableId
 private  Long id;

 private  Long purchaseId;

 private  Long skuId;

 private  Integer skuNum;

 private  BigDecimal skuPrice;

 private  Long wareId;

 private  Integer status;


}