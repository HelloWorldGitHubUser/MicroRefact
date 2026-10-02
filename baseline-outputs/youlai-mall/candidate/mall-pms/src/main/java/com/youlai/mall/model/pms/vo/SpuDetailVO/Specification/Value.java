package com.youlai.mall.model.pms.vo.SpuDetailVO.Specification;
 import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import java.util.List;
@Data
@Schema(description = "规格项")
public class Value {

@Schema(description = "规格项ID")
 private  Long id;

@Schema(description = "规格项值")
 private  String value;


}