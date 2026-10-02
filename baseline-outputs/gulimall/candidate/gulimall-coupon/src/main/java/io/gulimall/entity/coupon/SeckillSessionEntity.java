package io.gulimall.entity.coupon;
 import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
@Data
@TableName("sms_seckill_session")
public class SeckillSessionEntity implements Serializable{

 private  long serialVersionUID;

@TableId
 private  Long id;

 private  String name;

 private  Date startTime;

 private  Date endTime;

 private  Integer status;

 private  Date createTime;

@TableField(exist = false)
 private  List<SeckillSkuRelationEntity> relations;


}