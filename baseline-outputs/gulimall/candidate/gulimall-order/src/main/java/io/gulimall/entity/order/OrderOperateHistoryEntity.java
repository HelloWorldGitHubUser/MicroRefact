package io.gulimall.entity.order;
 import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;
@Data
@TableName("oms_order_operate_history")
public class OrderOperateHistoryEntity implements Serializable{

 private  long serialVersionUID;

@TableId
 private  Long id;

 private  Long orderId;

 private  String operateMan;

 private  Date createTime;

 private  Integer orderStatus;

 private  String note;


}