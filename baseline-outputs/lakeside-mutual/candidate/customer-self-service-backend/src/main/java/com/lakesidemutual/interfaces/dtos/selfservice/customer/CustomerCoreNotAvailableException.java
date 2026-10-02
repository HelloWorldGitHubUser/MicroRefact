package com.lakesidemutual.interfaces.dtos.selfservice.customer;
 import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
@ResponseStatus(code = HttpStatus.BAD_GATEWAY)
public class CustomerCoreNotAvailableException extends RuntimeException{

 private  long serialVersionUID;

public CustomerCoreNotAvailableException(String errorMessage) {
    super(errorMessage);
}
}