package com.lakesidemutual.interfaces.dtos.selfservice.insurancequoterequest;
 import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class InsuranceQuoteRequestNotFoundException extends RuntimeException{

 private  long serialVersionUID;

public InsuranceQuoteRequestNotFoundException(String errorMessage) {
    super(errorMessage);
}
}