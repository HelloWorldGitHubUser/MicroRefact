package com.youlai.mall.model.system.entity;
 import com.baomidou.mybatisplus.annotation.TableField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SysRoleMenu {

 private  Long roleId;

 private  Long menuId;

@TableField(exist = false)
 private  long serialVersionUID;


}