package com.goodskill.entity.mysql;
 import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.goodskill.entity.BaseColEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.io.Serial;
import java.io.Serializable;
@Data
@EqualsAndHashCode(callSuper = false)
public class Permission extends BaseColEntityimplements Serializable{

@Serial
 private  long serialVersionUID;

@TableId(value = "permission_id", type = IdType.AUTO)
 private  Integer permissionId;

 private  String permissionName;

 private  String permissionMenu;

 private  Integer parentPermissionId;

 private  String isDir;

 private  Integer orderNo;

 private  String permissionCode;


}