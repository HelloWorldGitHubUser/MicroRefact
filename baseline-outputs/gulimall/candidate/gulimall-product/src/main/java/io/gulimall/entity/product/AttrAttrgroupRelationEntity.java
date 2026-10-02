package io.gulimall.entity.product;
 import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;
@Data
@TableName("pms_attr_attrgroup_relation")
public class AttrAttrgroupRelationEntity implements Serializable{

 private  long serialVersionUID;

@TableId
 private  Long id;

 private  Long attrId;

 private  Long attrGroupId;

 private  Integer attrSort;


}