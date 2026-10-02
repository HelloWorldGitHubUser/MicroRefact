package com.youlai.mall.model.system.bo;
 import lombok.Data;
import java.util.Set;
@Data
public class RolePermsBO {

 private  String roleCode;

 private  Set<String> perms;


}