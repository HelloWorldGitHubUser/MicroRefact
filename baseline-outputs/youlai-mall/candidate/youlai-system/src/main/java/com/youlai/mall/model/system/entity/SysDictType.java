package com.youlai.mall.model.system.entity;
 import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.youlai.mall.base.BaseEntity;
import lombok.Data;
@Data
public class SysDictType extends BaseEntity{

@TableId(type = IdType.AUTO)
 private  Long id;

 private  String name;

 private  String code;

 private  Integer status;

 private  String remark;


}