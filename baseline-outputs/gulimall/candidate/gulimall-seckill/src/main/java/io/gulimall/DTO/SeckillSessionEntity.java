package io.gulimall.DTO;
 import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
public class SeckillSessionEntity implements Serializable{

 private  long serialVersionUID;

 private  Long id;

 private  String name;

 private  Date startTime;

 private  Date endTime;

 private  Integer status;

 private  Date createTime;

 private  List<SeckillSkuRelationEntity> relations;


}