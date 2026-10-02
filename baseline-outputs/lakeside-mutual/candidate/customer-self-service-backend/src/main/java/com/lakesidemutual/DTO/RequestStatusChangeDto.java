package com.lakesidemutual.DTO;
 import java.util.Date;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import com.lakesidemutual.domain.policy.RequestStatusChange;
public class RequestStatusChangeDto {

 private  Date date;

 private  String status;

 private RestTemplate restTemplate = new RestTemplate();

  String url = "http://3";

public RequestStatusChangeDto() {
}public RequestStatusChangeDto(Date date, String status) {
    this.date = date;
    this.status = status;
}
public Date getDate(){
    return date;
}


public String getStatus(){
    return status;
}


public void setDate(Date date){
    this.date = date;
 

  UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url.concat("/setDate"))

.queryParam("date",date)
;
restTemplate.put(builder.toUriString(),null);
}


public void setStatus(String status){
    this.status = status;
 

  UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url.concat("/setStatus"))

.queryParam("status",status)
;
restTemplate.put(builder.toUriString(),null);
}


}