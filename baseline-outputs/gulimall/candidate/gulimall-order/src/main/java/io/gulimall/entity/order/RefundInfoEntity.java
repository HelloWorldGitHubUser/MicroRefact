package io.gulimall.entity.order;
 import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.math.BigDecimal;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;
@Data
@TableName("oms_refund_info")
public class RefundInfoEntity implements Serializable{

 private  long serialVersionUID;

@TableId
 private  Long id;

 private  Long orderReturnId;

 private  BigDecimal refund;

 private  String refundSn;

 private  Integer refundStatus;

 private  Integer refundChannel;

 private  String refundContent;


}