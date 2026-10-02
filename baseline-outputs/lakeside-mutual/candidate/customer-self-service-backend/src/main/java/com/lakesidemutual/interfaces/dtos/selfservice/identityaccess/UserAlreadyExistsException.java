package com.lakesidemutual.interfaces.dtos.selfservice.identityaccess;
 import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
@ResponseStatus(code = HttpStatus.CONFLICT)
public class UserAlreadyExistsException extends RuntimeException{

 private  long serialVersionUID;

public UserAlreadyExistsException(String errorMessage) {
    super(errorMessage);
}
}