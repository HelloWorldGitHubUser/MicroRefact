package com.central.exception;
 public class IdempotencyException extends RuntimeException{

 private  long serialVersionUID;

public IdempotencyException(String message) {
    super(message);
}
}