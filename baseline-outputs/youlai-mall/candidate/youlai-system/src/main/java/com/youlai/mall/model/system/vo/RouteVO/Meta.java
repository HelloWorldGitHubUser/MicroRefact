package com.youlai.mall.model.system.vo.RouteVO;
 import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import java.util.List;
@Schema(description = "路由属性类型")
@Data
public class Meta {

@Schema(description = "路由title")
 private  String title;

@Schema(description = "ICON")
 private  String icon;

@Schema(description = "是否隐藏(true-是 false-否)", example = "true")
 private  Boolean hidden;

@Schema(description = "拥有路由权限的角色编码", example = "['ADMIN','ROOT']")
 private  List<String> roles;

@Schema(description = "【菜单】是否开启页面缓存", example = "true")
@JsonInclude(JsonInclude.Include.NON_NULL)
 private  Boolean keepAlive;

@Schema(description = "【目录】只有一个子路由是否始终显示", example = "true")
@JsonInclude(JsonInclude.Include.NON_NULL)
 private  Boolean alwaysShow;


}