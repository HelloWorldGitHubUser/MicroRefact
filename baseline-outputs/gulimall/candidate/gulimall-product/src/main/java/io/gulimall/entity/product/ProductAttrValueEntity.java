package io.gulimall.entity.product;
 import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;
@Data
@TableName("pms_product_attr_value")
public class ProductAttrValueEntity implements Serializable{

 private  long serialVersionUID;

@TableId
 private  Long id;

 private  Long spuId;

 private  Long attrId;

 private  String attrName;

 private  String attrValue;

 private  Integer attrSort;

 private  Integer quickShow;


}