package com.youlai.mall.model.pms.vo.SpuDetailVO;
 import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import java.util.List;
@Data
@Schema(description = "属性信息")
public class Attribute {

@Schema(description = "属性ID")
 private  Long id;

@Schema(description = "属性名称")
 private  String name;

@Schema(description = "属性值")
 private  String value;


}