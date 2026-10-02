package com.youlai.mall.model.pms.form.PmsCategoryAttributeForm;
 import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.util.List;
@Data
public class Attribute {

@Schema(description = "属性ID")
 private  Long id;

@Schema(description = "属性名称")
@NotBlank
 private  String name;


}