package io.gulimall.entity.product;
 import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;
@Data
@TableName("pms_attr")
public class AttrEntity implements Serializable{

 private  long serialVersionUID;

@TableId
 private  Long attrId;

 private  String attrName;

 private  Integer searchType;

 private  String icon;

 private  String valueSelect;

@TableField(exist = false)
 private  Integer valueType;

 private  Integer attrType;

 private  Long enable;

 private  Long catelogId;

 private  Integer showDesc;


}