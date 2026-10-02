package io.gulimall.entity.product;
 import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.math.BigDecimal;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;
@Data
@TableName("pms_sku_info")
public class SkuInfoEntity implements Serializable{

 private  long serialVersionUID;

@TableId
 private  Long skuId;

 private  Long spuId;

 private  String skuName;

 private  String skuDesc;

 private  Long catalogId;

 private  Long brandId;

 private  String skuDefaultImg;

 private  String skuTitle;

 private  String skuSubtitle;

 private  BigDecimal price;

 private  Long saleCount;


}