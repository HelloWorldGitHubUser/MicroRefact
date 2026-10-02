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
import java.util.Date;
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Goods implements Serializable{

@Serial
 private  long serialVersionUID;

@TableId(value = "goods_id", type = IdType.AUTO)
 private  Integer goodsId;

 private  String photoUrl;

 private  String name;

 private  String price;

@TableField(value = "create_time", fill = FieldFill.INSERT)
@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
 private  Date createTime;

 private  String introduce;


}