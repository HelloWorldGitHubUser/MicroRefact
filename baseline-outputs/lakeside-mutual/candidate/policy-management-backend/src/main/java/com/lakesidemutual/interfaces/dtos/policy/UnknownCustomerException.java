package com.lakesidemutual.interfaces.dtos.policy;
 import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
@ResponseStatus(code = HttpStatus.FAILED_DEPENDENCY)
public class UnknownCustomerException extends RuntimeException{

 private  long serialVersionUID;

public UnknownCustomerException(String errorMessage) {
    super(errorMessage);
}
}