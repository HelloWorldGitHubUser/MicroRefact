package com.youlai.mall.model.pms.entity;
 import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.youlai.mall.base.BaseEntity;
import lombok.Data;
@Data
public class PmsSku extends BaseEntity{

@TableId(type = IdType.AUTO)
 private  Long id;

 private  String skuSn;

 private  String name;

 private  Long spuId;

 private  String specIds;

 private  Long price;

 private  Integer stock;

 private  Integer lockedStock;

 private  String picUrl;


}