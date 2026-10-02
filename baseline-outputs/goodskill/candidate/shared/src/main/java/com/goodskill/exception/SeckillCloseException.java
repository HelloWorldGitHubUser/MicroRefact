package com.goodskill.exception;
 import java.io.Serial;
public class SeckillCloseException extends SeckillException{

@Serial
 private  long serialVersionUID;

public SeckillCloseException(String message) {
    super(message);
}public SeckillCloseException(String message, Throwable cause) {
    super(message, cause);
}
}