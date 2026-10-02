package com.youlai.mall.model.oms.vo.OmsOrderPageVO;
 import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
@Schema(description = "订单商品明细")
@Data
public class OrderItem {

@Schema(description = "商品ID")
 private  Long skuId;

@Schema(description = "商品规格名称")
 private  String skuName;

@Schema(description = "图片地址")
 private  String picUrl;

@Schema(description = "商品价格")
 private  Long price;

@Schema(description = "商品数量")
 private  Integer quantity;

@Schema(description = "商品总金额(单位：分)")
 private  Long totalAmount;


}