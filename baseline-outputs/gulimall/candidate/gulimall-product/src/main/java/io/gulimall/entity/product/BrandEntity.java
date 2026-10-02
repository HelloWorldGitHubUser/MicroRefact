package io.gulimall.entity.product;
 import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import io.gulimall.constraints.ListValue;
import io.gulimall.group.AddGroup;
import io.gulimall.group.UpdateGroup;
import lombok.Data;
import org.hibernate.validator.constraints.URL;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Pattern;
@Data
@TableName("pms_brand")
public class BrandEntity implements Serializable{

 private  long serialVersionUID;

@TableId
@Null(message = "添加时品牌id必须为空", groups = { AddGroup.class })
@NotNull(message = "修改时品牌id不能为空", groups = { UpdateGroup.class })
 private  Long brandId;

@NotEmpty(message = "品牌名必须提交", groups = { AddGroup.class, UpdateGroup.class })
 private  String name;

@URL(message = "提交品牌logo的地址不是有效网址", groups = { AddGroup.class, UpdateGroup.class })
 private  String logo;

 private  String descript;

@NotNull(message = "显示状态不能为空", groups = { AddGroup.class, UpdateGroup.class })
 private  Integer showStatus;

@NotEmpty(message = "检索首字母不能为空", groups = { AddGroup.class, UpdateGroup.class })
@Pattern(regexp = "^[a-zA-Z]$", message = "检索字符必须是一个字母", groups = { AddGroup.class, UpdateGroup.class })
 private  String firstLetter;

@NotNull(groups = { AddGroup.class, UpdateGroup.class })
 private  Integer sort;


}