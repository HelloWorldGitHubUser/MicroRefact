package io.gulimall.entity.product;
 import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;
@Data
@TableName("pms_category_brand_relation")
public class CategoryBrandRelationEntity implements Serializable{

 private  long serialVersionUID;

@TableId
 private  Long id;

 private  Long brandId;

 private  Long catelogId;

 private  String brandName;

 private  String catelogName;


}