package io.gulimall.entity.ware;
 import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;
@Data
@TableName("wms_ware_sku")
public class WareSkuEntity implements Serializable{

 private  long serialVersionUID;

@TableId
 private  Long id;

 private  Long skuId;

 private  Long wareId;

 private  Integer stock;

 private  String skuName;

 private  Integer stockLocked;


}