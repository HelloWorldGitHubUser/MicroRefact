package com.youlai.mall.model.oms.entity;
 import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.youlai.mall.base.BaseEntity;
import lombok.Data;
@Data
public class OmsOrderLog extends BaseEntity{

@TableId(type = IdType.AUTO)
 private  Long id;

 private  Long orderId;

 private  String user;

 private  String detail;

 private  Integer orderStatus;

 private  String remark;

 private  Integer deleted;


}