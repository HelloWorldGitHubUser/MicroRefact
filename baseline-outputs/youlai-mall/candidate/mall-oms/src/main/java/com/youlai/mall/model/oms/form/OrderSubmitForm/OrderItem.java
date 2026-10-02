package com.youlai.mall.model.oms.form.OrderSubmitForm;
 import com.youlai.mall.enums.OrderSourceEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.ToString;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.util.List;
@Schema(description = "订单商品")
@Data
public class OrderItem {

@Schema(description = "SKU ID")
 private  Long skuId;

@Schema(description = "SKU 编号")
 private  String skuSn;

@Schema(description = "SKU 名称")
 private  String skuName;

@Schema(description = "商品图片URL")
 private  String picUrl;

@Schema(description = "商品价格(单位:分)")
 private  Long price;

@Schema(description = "商品名称")
 private  String spuName;

@Schema(description = "商品数量")
 private  Integer quantity;


}