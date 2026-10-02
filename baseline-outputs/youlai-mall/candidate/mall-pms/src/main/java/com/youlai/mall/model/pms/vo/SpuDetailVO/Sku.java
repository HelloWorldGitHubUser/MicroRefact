package com.youlai.mall.model.pms.vo.SpuDetailVO;
 import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import java.util.List;
@Data
@Schema(description = "商品库存单元")
public class Sku {

@Schema(description = "库存单元ID")
 private  Long id;

@Schema(description = "库存单元名称")
 private  String name;

@Schema(description = "库存单元规格值ID集合，以英文逗号拼接")
 private  String specIds;

@Schema(description = "价格")
 private  Long price;

@Schema(description = "库存")
 private  Integer stock;

@Schema(description = "商品图片URL")
 private  String picUrl;


}