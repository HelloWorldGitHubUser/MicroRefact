package com.hoangtien2k3.ecommerce.event;
 import com.hoangtien2k3.ecommerce.dto.PaymentEventDto;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;
import com.hoangtien2k3.ecommerce.Interface.PaymentEventDto;
@Getter
public class PaymentSuccessEvent extends ApplicationEvent{

 private  PaymentEventDto paymentInfo;

public PaymentSuccessEvent(Object source, PaymentEventDto paymentInfo) {
    super(source);
    this.paymentInfo = paymentInfo;
}
}