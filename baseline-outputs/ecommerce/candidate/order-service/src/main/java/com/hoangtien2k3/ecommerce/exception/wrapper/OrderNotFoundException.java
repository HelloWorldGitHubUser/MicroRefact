package com.hoangtien2k3.ecommerce.exception.wrapper;
 import java.io.Serial;
public class OrderNotFoundException extends RuntimeException{

@Serial
 private  long serialVersionUID;

public OrderNotFoundException() {
    super();
}public OrderNotFoundException(String message, Throwable cause) {
    super(message, cause);
}public OrderNotFoundException(String message) {
    super(message);
}public OrderNotFoundException(Throwable cause) {
    super(cause);
}
}