package com.hoangtien2k3.ecommerce.exception.wrapper;
 import java.io.Serial;
public class ProductNotFoundException extends RuntimeException{

@Serial
 private  long serialVersionUID;

public ProductNotFoundException() {
    super();
}public ProductNotFoundException(String message, Throwable cause) {
    super(message, cause);
}public ProductNotFoundException(String message) {
    super(message);
}public ProductNotFoundException(Throwable cause) {
    super(cause);
}
}