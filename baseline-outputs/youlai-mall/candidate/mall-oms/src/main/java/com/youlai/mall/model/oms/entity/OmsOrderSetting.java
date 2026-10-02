package com.youlai.mall.model.oms.entity;
 import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.youlai.mall.base.BaseEntity;
import lombok.Data;
@Data
public class OmsOrderSetting extends BaseEntity{

@TableId(type = IdType.AUTO)
 private  Long id;

 private  Integer flashOrderOvertime;

 private  Integer normalOrderOvertime;

 private  Integer confirmOvertime;

 private  Integer finishOvertime;

 private  Integer commentOvertime;

 private  Integer memberLevel;

 private  Integer deleted;


}