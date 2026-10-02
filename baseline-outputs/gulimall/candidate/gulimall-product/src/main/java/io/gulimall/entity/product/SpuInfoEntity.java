package io.gulimall.entity.product;
 import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.math.BigDecimal;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;
@Data
@TableName("pms_spu_info")
public class SpuInfoEntity implements Serializable{

 private  long serialVersionUID;

@TableId
 private  Long id;

 private  String spuName;

 private  String spuDescription;

 private  Long catalogId;

 private  Long brandId;

@TableField(exist = false)
 private  String brandName;

 private  BigDecimal weight;

 private  Integer publishStatus;

 private  Date createTime;

 private  Date updateTime;


}