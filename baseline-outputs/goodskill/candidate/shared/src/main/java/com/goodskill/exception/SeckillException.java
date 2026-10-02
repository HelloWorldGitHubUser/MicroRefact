package com.goodskill.exception;
 import java.io.Serial;
public class SeckillException extends RuntimeException{

@Serial
 private  long serialVersionUID;

public SeckillException(String message, Throwable cause) {
    super(message, cause);
}public SeckillException(String message) {
    super(message);
}
}