package com.goodskill.entity.mysql;
 import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Seckill implements Serializable{

@Serial
 private  long serialVersionUID;

@TableId(value = "seckill_id", type = IdType.AUTO)
 private  Long seckillId;

 private  String name;

 private  Integer number;

@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
 private  Date startTime;

@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
 private  Date endTime;

@TableField(value = "create_time", fill = FieldFill.INSERT)
@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
 private  Date createTime;

 private  Integer goodsId;

 private  BigDecimal price;

 private  String status;

 private  String createUser;


}