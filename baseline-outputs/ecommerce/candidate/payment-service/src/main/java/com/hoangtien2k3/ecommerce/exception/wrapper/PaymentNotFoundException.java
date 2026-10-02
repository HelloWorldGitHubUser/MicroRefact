package com.hoangtien2k3.ecommerce.exception.wrapper;
 import java.io.Serial;
public class PaymentNotFoundException extends RuntimeException{

@Serial
 private  long serialVersionUID;

public PaymentNotFoundException() {
    super();
}public PaymentNotFoundException(String message, Throwable cause) {
    super(message, cause);
}public PaymentNotFoundException(String message) {
    super(message);
}public PaymentNotFoundException(Throwable cause) {
    super(cause);
}
}