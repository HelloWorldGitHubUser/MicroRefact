package com.central.exception;
 public class BusinessException extends RuntimeException{

 private  long serialVersionUID;

public BusinessException(String message) {
    super(message);
}
}