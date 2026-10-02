package io.gulimall.entity.ware;
 import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Builder;
import lombok.Data;
@Data
@Builder
@TableName("wms_ware_order_task_detail")
public class WareOrderTaskDetailEntity implements Serializable{

 private  long serialVersionUID;

@TableId
 private  Long id;

 private  Long skuId;

 private  String skuName;

 private  Integer skuNum;

 private  Long taskId;

 private  Long wareId;

 private  Integer lockStatus;


}