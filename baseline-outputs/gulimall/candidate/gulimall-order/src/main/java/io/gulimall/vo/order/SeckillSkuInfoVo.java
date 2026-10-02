package io.gulimall.vo.order;
 import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import java.math.BigDecimal;
@Data
public class SeckillSkuInfoVo {

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