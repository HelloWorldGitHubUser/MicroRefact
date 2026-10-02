package com.lakesidemutual.interfaces.dtos.policy.insurancequoterequest;
 import java.util.Date;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import com.lakesidemutual.domain.policy.RequestStatusChange;
public class RequestStatusChangeDto {

@Valid
 private  Date date;

@NotEmpty
 private  String status;

public RequestStatusChangeDto() {
}public RequestStatusChangeDto(Date date, String status) {
    this.date = date;
    this.status = status;
}
public void setDate(Date date){
    this.date = date;
}


public Date getDate(){
    return date;
}


public String getStatus(){
    return status;
}


public void setStatus(String status){
    this.status = status;
}


public RequestStatusChangeDto fromDomainObject(RequestStatusChange requestStatusChange){
    return new RequestStatusChangeDto(requestStatusChange.getDate(), requestStatusChange.getStatus().name());
}


}