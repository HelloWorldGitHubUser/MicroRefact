package com.hoangtien2k3.ecommerce.dto.order;
 import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hoangtien2k3.ecommerce.dto.response.UserResponse;
import lombok;
import java.io.Serial;
import java.io.Serializable;
import java.util.Set;
import com.hoangtien2k3.ecommerce.Interface.UserResponse;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
@Builder
public class CartDto implements Serializable{

@Serial
 private  long serialVersionUID;

 private  Integer cartId;

 private  Long userId;

@JsonProperty("order")
@JsonInclude(Include.NON_NULL)
 private  Set<OrderDto> orderDtos;

@JsonProperty("user")
@JsonInclude(Include.NON_NULL)
 private  UserResponse userDto;


}