package io.gulimall.entity.coupon;
 import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;
@Data
@TableName("sms_home_adv")
public class HomeAdvEntity implements Serializable{

 private  long serialVersionUID;

@TableId
 private  Long id;

 private  String name;

 private  String pic;

 private  Date startTime;

 private  Date endTime;

 private  Integer status;

 private  Integer clickCount;

 private  String url;

 private  String note;

 private  Integer sort;

 private  Long publisherId;

 private  Long authId;


}