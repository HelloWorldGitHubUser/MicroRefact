package io.gulimall.vo.order;
 import lombok.Data;
import java.math.BigDecimal;
@Data
public class OrderSubmitVo {

 private  Long addrId;

 private  Integer payType;

 private  String orderToken;

 private  BigDecimal payPrice;

 private  String remarks;


}