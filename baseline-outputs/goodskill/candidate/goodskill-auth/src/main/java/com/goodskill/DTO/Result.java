package com.goodskill.DTO;
 import lombok.Data;
import java.io.Serial;
import java.io.Serializable;
public class Result implements Serializable{

 private  long serialVersionUID;

 public  int SUCCESS;

 public  int FAIL;

 private  int code;

 private  String msg;

 private  T data;

 private RestTemplate restTemplate = new RestTemplate();

  String url = "http://6";


public Result<T> ok(T data,String msg){
    return restResult(data, SUCCESS, msg);
 

  UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url.concat("/ok"))

.queryParam("data",data)
.queryParam("msg",msg)
;
Result<T> aux = restTemplate.getForObject(builder.toUriString(),Result<T>.class);
return aux;
}


}