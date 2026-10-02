package com.hoangtien2k3.ecommerce.exception.wrapper;
 import java.io.Serial;
public class OrderItemNotFoundException extends RuntimeException{

@Serial
 private  long serialVersionUID;

public OrderItemNotFoundException() {
    super();
}public OrderItemNotFoundException(String message, Throwable cause) {
    super(message, cause);
}public OrderItemNotFoundException(String message) {
    super(message);
}public OrderItemNotFoundException(Throwable cause) {
    super(cause);
}
}