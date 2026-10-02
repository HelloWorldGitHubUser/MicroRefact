package io.gulimall.entity.product;
 import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;
@Data
@TableName("pms_spu_info_desc")
public class SpuInfoDescEntity implements Serializable{

 private  long serialVersionUID;

@TableId(type = IdType.INPUT)
 private  Long spuId;

 private  String decript;


}