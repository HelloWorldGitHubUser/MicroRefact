package com.youlai.mall.model.pms.entity;
 import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.youlai.mall.base.BaseEntity;
import lombok.Data;
@Data
public class PmsSpuAttribute extends BaseEntity{

@TableId(type = IdType.AUTO)
 private  Long id;

 private  Long spuId;

 private  Long attributeId;

 private  String name;

 private  String value;

 private  Integer type;

 private  String picUrl;


}