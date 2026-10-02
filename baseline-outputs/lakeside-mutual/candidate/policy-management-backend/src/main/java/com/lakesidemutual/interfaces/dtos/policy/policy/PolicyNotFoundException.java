package com.lakesidemutual.interfaces.dtos.policy.policy;
 import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class PolicyNotFoundException extends RuntimeException{

 private  long serialVersionUID;

public PolicyNotFoundException(String errorMessage) {
    super(errorMessage);
}
}