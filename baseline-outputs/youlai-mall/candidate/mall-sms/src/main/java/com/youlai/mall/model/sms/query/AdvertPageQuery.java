package com.youlai.mall.model.sms.query;
 import com.youlai.mall.base.BasePageQuery;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
@Schema(description = "广告分页查询对象")
@Data
public class AdvertPageQuery extends BasePageQuery{

@Schema(description = "关键字")
 private  String keywords;


}