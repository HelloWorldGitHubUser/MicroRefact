package com.hoangtien2k3.ecommerce.helper;
 import com.hoangtien2k3.ecommerce.dto.PaymentDto;
import com.hoangtien2k3.ecommerce.dto.response.OrderResponse;
import com.hoangtien2k3.ecommerce.dto.response.UserResponse;
import com.hoangtien2k3.ecommerce.model.payment.Payment;
public interface PaymentMappingHelper {


public Payment map(PaymentDto paymentDto){
    return Payment.builder().paymentId(paymentDto.getPaymentId()).orderId(paymentDto.getOrderId()).userId(paymentDto.getUserId()).isPayed(paymentDto.getIsPayed()).paymentStatus(paymentDto.getPaymentStatus()).build();
}
;

}