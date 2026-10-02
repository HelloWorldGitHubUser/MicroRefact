package com.youlai.mall.model.oms.vo;
 import lombok.Data;
import lombok.experimental.Accessors;
@Data
@Accessors(chain = true)
public class WxPayResponseVO {

 private  String code;

 private  String message;


}