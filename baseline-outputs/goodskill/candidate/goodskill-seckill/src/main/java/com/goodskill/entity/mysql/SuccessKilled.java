package com.goodskill.entity.mysql;
 import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class SuccessKilled implements Serializable{

@Serial
 private  long serialVersionUID;

 private  Long seckillId;

 private  String userPhone;

 private  Integer status;

@TableField(value = "create_time", fill = FieldFill.INSERT)
@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
 private  Date createTime;

 private  String serverIp;

 private  String userIp;

 private  String userId;


}