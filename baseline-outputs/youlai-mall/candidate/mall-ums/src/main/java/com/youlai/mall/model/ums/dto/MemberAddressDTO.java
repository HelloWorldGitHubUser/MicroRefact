package com.youlai.mall.model.ums.dto;
 import lombok.Data;
@Data
public class MemberAddressDTO {

 private  Long id;

 private  Long memberId;

 private  String consigneeName;

 private  String consigneeMobile;

 private  String province;

 private  String city;

 private  String area;

 private  String detailAddress;

 private  Integer defaulted;


}