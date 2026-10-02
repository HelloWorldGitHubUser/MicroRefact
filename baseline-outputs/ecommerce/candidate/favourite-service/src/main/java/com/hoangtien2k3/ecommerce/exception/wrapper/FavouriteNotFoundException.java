package com.hoangtien2k3.ecommerce.exception.wrapper;
 import java.io.Serial;
public class FavouriteNotFoundException extends RuntimeException{

@Serial
 private  long serialVersionUID;

public FavouriteNotFoundException() {
    super();
}public FavouriteNotFoundException(String message, Throwable cause) {
    super(message, cause);
}public FavouriteNotFoundException(String message) {
    super(message);
}public FavouriteNotFoundException(Throwable cause) {
    super(cause);
}
}