package com.hoangtien2k3.ecommerce.dto;
 import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hoangtien2k3.ecommerce.dto.response.OrderResponse;
import com.hoangtien2k3.ecommerce.dto.response.UserResponse;
import com.hoangtien2k3.ecommerce.model.payment.PaymentStatus;
import lombok;
import java.io.Serial;
import java.io.Serializable;
import com.hoangtien2k3.ecommerce.Interface.OrderResponse;
import com.hoangtien2k3.ecommerce.Interface.UserResponse;
@NoArgsConstructor
@AllArgsConstructor
@Data
@Setter
@Getter
@Builder
public class PaymentDto implements Serializable{

@Serial
 private  long serialVersionUID;

 private  Integer paymentId;

 private  Boolean isPayed;

 private  PaymentStatus paymentStatus;

 private  Integer orderId;

 private  Long userId;

@JsonProperty("order")
@JsonInclude(Include.NON_NULL)
 private  OrderResponse orderDto;

@JsonProperty("user")
@JsonInclude(Include.NON_NULL)
 private  UserResponse userDto;


}