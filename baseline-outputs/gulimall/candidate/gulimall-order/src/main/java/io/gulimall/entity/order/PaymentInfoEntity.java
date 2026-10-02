package io.gulimall.entity.order;
 import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.math.BigDecimal;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;
@Data
@TableName("oms_payment_info")
public class PaymentInfoEntity implements Serializable{

 private  long serialVersionUID;

@TableId
 private  Long id;

 private  String orderSn;

 private  Long orderId;

 private  String alipayTradeNo;

 private  BigDecimal totalAmount;

 private  String subject;

 private  String paymentStatus;

 private  Date createTime;

 private  Date confirmTime;

 private  String callbackContent;

 private  Date callbackTime;


}