package com.central.DTO;
 import com.central.enums.CodeEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;
public class Result implements Serializable{

 private  T datas;

 private  Integer resp_code;

 private  String resp_msg;

 private RestTemplate restTemplate = new RestTemplate();

  String url = "http://5";


public Result<T> failed(T model,String msg){
    return of(model, CodeEnum.ERROR.getCode(), msg);
 

  UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url.concat("/failed"))

.queryParam("model",model)
.queryParam("msg",msg)
;
Result<T> aux = restTemplate.getForObject(builder.toUriString(),Result<T>.class);
return aux;
}


public Result<T> succeed(T model){
    return of(model, CodeEnum.SUCCESS.getCode(), "");
 

  UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url.concat("/succeed"))

.queryParam("model",model)
;
Result<T> aux = restTemplate.getForObject(builder.toUriString(),Result<T>.class);
return aux;
}


}