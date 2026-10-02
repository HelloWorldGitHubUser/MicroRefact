package io.gulimall.entity.order;
 import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;
@Data
@TableName("oms_order_setting")
public class OrderSettingEntity implements Serializable{

 private  long serialVersionUID;

@TableId
 private  Long id;

 private  Integer flashOrderOvertime;

 private  Integer normalOrderOvertime;

 private  Integer confirmOvertime;

 private  Integer finishOvertime;

 private  Integer commentOvertime;

 private  Integer memberLevel;


}