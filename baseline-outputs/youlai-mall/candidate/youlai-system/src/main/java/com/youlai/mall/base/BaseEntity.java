package com.youlai.mall.base;
 import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
@Data
public class BaseEntity implements Serializable{

@Serial
 private  long serialVersionUID;

@TableField(fill = FieldFill.INSERT)
 private  LocalDateTime createTime;

@TableField(fill = FieldFill.INSERT_UPDATE)
 private  LocalDateTime updateTime;


}