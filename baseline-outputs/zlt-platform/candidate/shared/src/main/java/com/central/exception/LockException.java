package com.central.exception;
 public class LockException extends RuntimeException{

 private  long serialVersionUID;

public LockException(String message) {
    super(message);
}
}