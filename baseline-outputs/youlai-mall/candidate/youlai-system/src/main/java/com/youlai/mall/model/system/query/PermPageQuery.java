package com.youlai.mall.model.system.query;
 import com.youlai.mall.base.BasePageQuery;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
@Data
@Schema
public class PermPageQuery extends BasePageQuery{

@Schema(description = "权限名称")
 private  String name;

@Schema(description = "菜单ID")
 private  Long menuId;


}