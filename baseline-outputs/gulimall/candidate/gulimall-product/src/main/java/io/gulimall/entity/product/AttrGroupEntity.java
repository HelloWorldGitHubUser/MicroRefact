package io.gulimall.entity.product;
 import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;
@Data
@TableName("pms_attr_group")
public class AttrGroupEntity implements Serializable{

 private  long serialVersionUID;

@TableId
 private  Long attrGroupId;

 private  String attrGroupName;

 private  Integer sort;

 private  String descript;

 private  String icon;

 private  Long catelogId;

@TableField(exist = false)
 private  Long[] catelogPath;


}