package io.gulimall.entity.coupon;
 import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;
@Data
@TableName("sms_home_subject_spu")
public class HomeSubjectSpuEntity implements Serializable{

 private  long serialVersionUID;

@TableId
 private  Long id;

 private  String name;

 private  Long subjectId;

 private  Long spuId;

 private  Integer sort;


}