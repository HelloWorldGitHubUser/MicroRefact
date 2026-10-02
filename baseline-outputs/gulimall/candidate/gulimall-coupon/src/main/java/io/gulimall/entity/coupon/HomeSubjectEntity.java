package io.gulimall.entity.coupon;
 import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;
@Data
@TableName("sms_home_subject")
public class HomeSubjectEntity implements Serializable{

 private  long serialVersionUID;

@TableId
 private  Long id;

 private  String name;

 private  String title;

 private  String subTitle;

 private  Integer status;

 private  String url;

 private  Integer sort;

 private  String img;


}