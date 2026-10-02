package com.youlai.mall.model.pms.query;
 import com.youlai.mall.base.BasePageQuery;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
@Schema(description = "品牌分页查询对象")
@Data
public class BrandPageQuery extends BasePageQuery{

@Schema(description = "关键字")
 private  String keywords;


}