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
@Schema(description = "收获地址")
@Data
public class ShippingAddress {

@Schema(description = "收货人姓名")
 private  String consigneeName;

@Schema(description = "收货人手机号")
 private  String consigneeMobile;

@Schema(description = "省份")
 private  String province;

@Schema(description = "城市")
 private  String city;

@Schema(description = "区域")
 private  String district;

@Schema(description = "详细地址")
 private  String detailAddress;


}