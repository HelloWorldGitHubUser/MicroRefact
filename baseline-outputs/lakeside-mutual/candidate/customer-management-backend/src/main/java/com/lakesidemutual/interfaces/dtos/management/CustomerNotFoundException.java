package com.lakesidemutual.interfaces.dtos.management;
 import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class CustomerNotFoundException extends RuntimeException{

 private  long serialVersionUID;

public CustomerNotFoundException(String errorMessage) {
    super(errorMessage);
}
}