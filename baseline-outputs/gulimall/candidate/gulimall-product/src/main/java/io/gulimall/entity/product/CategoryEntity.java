package io.gulimall.entity.product;
 import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
@Data
@TableName("pms_category")
public class CategoryEntity implements Serializable{

 private  long serialVersionUID;

@TableId
 private  Long catId;

 private  String name;

 private  Long parentCid;

 private  Integer catLevel;

@TableLogic(value = "1", delval = "0")
 private  Integer showStatus;

 private  Integer sort;

 private  String icon;

 private  String productUnit;

 private  Integer productCount;

// 表示该字段不是数据库中的字段
@TableField(exist = false)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
 private  List<CategoryEntity> children;


}