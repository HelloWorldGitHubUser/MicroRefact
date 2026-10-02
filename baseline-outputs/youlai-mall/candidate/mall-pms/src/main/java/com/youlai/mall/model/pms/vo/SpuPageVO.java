package com.youlai.mall.model.pms.vo;
 import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
@Schema(description = "商品分页对象")
@Data
public class SpuPageVO {

@Schema(description = "商品ID")
 private  Long id;

@Schema(description = "商品名称")
 private  String name;

@Schema(description = "商品价格(单位：分)")
 private  Long price;

@Schema(description = "销量")
 private  Integer sales;

@Schema(description = "图片地址")
 private  String picUrl;


}