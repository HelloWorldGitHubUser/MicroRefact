package com.youlai.mall.model.system.bo;
 import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.youlai.mall.enums.MenuTypeEnum;
import lombok.Data;
import java.util.List;
@Data
public class RouteBO {

@TableId(type = IdType.AUTO)
 private  Long id;

 private  Long parentId;

 private  String name;

 private  MenuTypeEnum type;

 private  String path;

 private  String component;

 private  String perm;

 private  Integer visible;

 private  Integer sort;

 private  String icon;

 private  String redirect;

 private  List<String> roles;

 private  Integer alwaysShow;

 private  Integer keepAlive;


}