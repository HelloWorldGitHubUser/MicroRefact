package com.youlai.mall.model.pms.vo.SpuDetailVO;
 import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import java.util.List;
@Data
@Schema(description = "商品信息")
public class GoodsInfo {

@Schema(description = "商品ID")
 private  Long id;

@Schema(description = "商品名称")
 private  String name;

@Schema(description = "商品原价（单位：分）")
 private  Long originPrice;

@Schema(description = "商品零售价（单位：分）")
 private  Long price;

@Schema(description = "销量")
 private  Integer sales;

@Schema(description = "商品图册")
 private  List<String> album;

@Schema(description = "商品详情")
 private  String detail;


}