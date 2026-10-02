package com.youlai.mall.model.system.query;
 import com.youlai.mall.base.BasePageQuery;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
@Data
public class RolePageQuery extends BasePageQuery{

@Schema(description = "关键字(角色名称/角色编码)")
 private  String keywords;


}