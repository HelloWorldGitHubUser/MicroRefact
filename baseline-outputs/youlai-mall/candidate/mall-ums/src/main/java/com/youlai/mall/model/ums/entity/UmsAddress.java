package com.youlai.mall.model.ums.entity;
 import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.youlai.mall.base.BaseEntity;
import lombok.Data;
@Data
public class UmsAddress extends BaseEntity{

@TableId(type = IdType.AUTO)
 private  Long id;

 private  Long memberId;

 private  String consigneeName;

 private  String consigneeMobile;

 private  String province;

 private  String city;

 private  String area;

 private  String detailAddress;

 private  String zipCode;

 private  Integer defaulted;


}