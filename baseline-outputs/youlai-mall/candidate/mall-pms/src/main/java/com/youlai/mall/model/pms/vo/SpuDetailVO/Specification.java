package com.youlai.mall.model.pms.vo.SpuDetailVO;
 import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import java.util.List;
@Data
@Schema(description = "规格信息")
public class Specification {

@Schema(description = "规格名称", example = "颜色")
 private  String name;

@Schema(description = "规格项列表", example = "黑,白")
 private  List<Value> values;

@Schema(description = "规格项ID")
 private  Long id;

@Schema(description = "规格项值")
 private  String value;


}